package com.shop.freshcart.services;

import com.shop.freshcart.dto.OrderItemResponseDTO;
import com.shop.freshcart.entities.Order_items;
import com.shop.freshcart.entities.Products;
import com.shop.freshcart.exception.ResourceNotFoundException;
import com.shop.freshcart.repository.OrderItemRepository;
import com.shop.freshcart.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    public OrderItemService(OrderItemRepository orderItemRepository, ProductService productService) {
        this.orderItemRepository = orderItemRepository;
        this.productService = productService;
    }

    public List<OrderItemResponseDTO> getItemsByOrderId(Long orderId) {
        List<Order_items> items = orderItemRepository.findByOrderId(orderId);

        if (items.isEmpty()) {
            throw new ResourceNotFoundException("No items found for order ID: " + orderId);
        }

        return items.stream().map(item -> {
            Products product = productService.getProductById(item.getProduct().getId());
            return new OrderItemResponseDTO(
                    item.getOrder().getId(),
                    product.getId(),
                    product.getName(),
                    item.getQuantity(),
                    item.getPrice()
            );
        }).collect(Collectors.toList());
    }
}
