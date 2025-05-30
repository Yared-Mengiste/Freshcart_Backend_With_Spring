//package com.shop.freshcart.service;
//
//import com.shop.freshcart.dto.DeliveryDTO;
//import com.shop.freshcart.dto.DeliveryResponseDTO;
//import com.shop.freshcart.entities.Delivery;
//import com.shop.freshcart.entities.Order;
//import com.shop.freshcart.entities.Shop;
//import com.shop.freshcart.entities.User;
//import com.shop.freshcart.mapper.DeliveryMapper;
//import com.shop.freshcart.repository.DeliveryRepository;
//import com.shop.freshcart.repository.OrderRepository;
//import com.shop.freshcart.repository.ShopRepository;
//import com.shop.freshcart.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class DeliveryService {
//
//    private final DeliveryRepository deliveryRepository;
//    private final OrderRepository orderRepository;
//    private final UserRepository userRepository;
//    private final ShopRepository shopRepository;
//    private final DeliveryMapper deliveryMapper;
//
//    // Create a delivery
//    public ResponseEntity<?> createDelivery(DeliveryDTO dto) {
//        // Validate foreign keys
//        Order order = orderRepository.findById(dto.getOrderId())
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        User user = userRepository.findById(dto.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Shop shop = shopRepository.findById(dto.getShopId())
//                .orElseThrow(() -> new RuntimeException("Shop not found"));
//
//        Delivery delivery = deliveryMapper.toEntity(dto);
//
//        // Optional but safe: set the actual objects (to ensure managed state)
//        delivery.setOrder(order);
//        delivery.setUser(user);
//        delivery.setShop(shop);
//        //ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault());
//        delivery.setCreatedAt(Instant.now());
//        delivery.setStatus("Pending");
//
//        Delivery deliveryOpt = deliveryRepository.save(delivery);
//        return ResponseEntity.ok(deliveryMapper.toDto(deliveryOpt));
//    }
//
//
//
//
//    public ResponseEntity<?> getAllDeliveries() {
//        List<Delivery> deliveries = deliveryRepository.findAll();
//        List<DeliveryResponseDTO> dtoList = deliveries.stream()
//                .map(deliveryMapper::toDto)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(dtoList);
//    }
//
//    public ResponseEntity<?> getDeliveriesByUserId(Long userId) {
//        List<Delivery> deliveries = deliveryRepository.findByUserId(userId);
//        List<DeliveryResponseDTO> dtoList = deliveries.stream()
//                .map(deliveryMapper::toDto) // Use correct mapping method
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(dtoList);
//    }
//
//
//    public ResponseEntity<?> getDeliveriesByDriverId(Long driverId) {
//        List<Delivery> deliveries = deliveryRepository.findByDriverId(driverId);
//        List<DeliveryResponseDTO> dtoList = deliveries.stream()
//                .map(deliveryMapper::toDto)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(dtoList);
//    }
//}
