package com.shop.freshcart.service;

import com.shop.freshcart.dto.DeliveryDTO;
import com.shop.freshcart.dto.DeliveryResponseDTO;
import com.shop.freshcart.entities.Delivery;
import com.shop.freshcart.entities.Order;
import com.shop.freshcart.entities.Shop;
import com.shop.freshcart.entities.User;
import com.shop.freshcart.mapper.DeliveryMapper;
import com.shop.freshcart.repository.DeliveryRepository;
import com.shop.freshcart.repository.OrderRepository;
import com.shop.freshcart.repository.ShopRepository;
import com.shop.freshcart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final DeliveryMapper deliveryMapper;

    // Create a delivery




    public ResponseEntity<?> getAllDeliveries() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        List<DeliveryResponseDTO> dtoList = deliveries.stream()
                .map(deliveryMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    public ResponseEntity<?> getDeliveriesByUserId(Long userId) {
        List<Delivery> deliveries = deliveryRepository.findByUserId(userId);
        List<DeliveryResponseDTO> dtoList = deliveries.stream()
                .map(deliveryMapper::toDto) // Use correct mapping method
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }


    public ResponseEntity<?> getDeliveriesByDriverId(Long driverId) {
        List<Delivery> deliveries = deliveryRepository.findByDriverId(driverId);
        List<DeliveryResponseDTO> dtoList = deliveries.stream()
                .map(deliveryMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
