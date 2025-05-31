package com.shop.freshcart.service;

import com.shop.freshcart.dto.*;
import com.shop.freshcart.entities.*;
import com.shop.freshcart.exception.EmptyFieldException;
import com.shop.freshcart.exception.ResourceNotFoundException;
import com.shop.freshcart.mapper.DeliveryMapper;
import com.shop.freshcart.mapper.OrderCreateMapper;
import com.shop.freshcart.mapper.OrderItemMapper;
import com.shop.freshcart.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderCreateMapper orderCreateMapper;
    private final OrderItemMapper orderItemMapper;
    private final ShopRepository shopRepository;
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @CacheEvict(value = "userOrders", key = "#dto.userId")
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new EmptyFieldException("No items provided.");
        }

        Order order = orderCreateMapper.toEntity(dto);
        order.setUser(user);
        Order savedOrder = orderRepository.save(order);

        List<Order_items> itemsToSave = new ArrayList<>();
        for (OrderItemDTO itemDTO : dto.getItems()) {
            Products product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found: ID " + itemDTO.getProductId()));

            Order_items item = orderItemMapper.toEntity(itemDTO);
            item.setProduct(product);
            item.setOrder(savedOrder);
            item.setPrice(itemDTO.getPrice());
            itemsToSave.add(item);
        }
        List<Order_items> savedItems = orderItemRepository.saveAll(itemsToSave);

        List<User> drivers = userRepository.findDriversBySubcity(user.getSubcity());
        if (drivers.isEmpty()) {
            throw new ResourceNotFoundException("No available drivers in user's subcity.");
        }
        User driver = drivers.getFirst();

        Shop shop = shopRepository.findFirstBySubcityIgnoreCase(user.getSubcity())
                .orElseThrow(() -> new ResourceNotFoundException("No available shops in user's subcity."));

        Delivery delivery = deliveryMapper.toEntity(user, driver, shop, savedOrder);
        Delivery savedDelivery = deliveryRepository.save(delivery);

        OrderResponseDTO response = orderCreateMapper.toResponseDto(savedOrder);
        response.setUserId(user.getId());
        response.setOrderItems(savedItems.stream()
                .map(orderItemMapper::toDto)
                .collect(Collectors.toList()));
        response.setDeliveries(List.of(deliveryMapper.toResponseDto(savedDelivery)));

        return response;
    }



    @Cacheable(value = "userOrders", key = "#userId")
    public List<OrderResponseDTO> getOrdersByUser(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream().map(order -> {
            OrderResponseDTO responseDTO = orderCreateMapper.toResponseDto(order);
            responseDTO.setUserId(order.getUser().getId());

            List<Order_items> items = orderItemRepository.findByOrderId(order.getId());
            responseDTO.setOrderItems(items.stream().map(orderItemMapper::toDto).collect(Collectors.toList()));
            return responseDTO;
        }).collect(Collectors.toList());
    }

    @Cacheable(value = "orders", key = "#orderId")
    public OrderResponseDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        OrderResponseDTO response = orderCreateMapper.toResponseDto(order);
        response.setUserId(order.getUser().getId());

        List<Order_items> items = orderItemRepository.findByOrderId(order.getId());
        response.setOrderItems(items.stream().map(orderItemMapper::toDto).collect(Collectors.toList()));

        return response;
    }

    @Caching(evict = {
            @CacheEvict(value = "orders", key = "#orderId"),
            @CacheEvict(value = "userOrders", allEntries = true)
    })
    public String updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setStatus(status);
        orderRepository.save(order);

        return "Order status updated to " + status;
    }
}



