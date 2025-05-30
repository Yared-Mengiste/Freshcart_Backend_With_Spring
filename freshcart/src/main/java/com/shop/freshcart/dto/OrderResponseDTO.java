package com.shop.freshcart.dto;

import com.shop.freshcart.entities.Delivery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {
    private Long id;
    private Double totalPrice;
    private String status;
    private LocalDateTime createdAt;
    private Long userId;  // Only the userId is included
    private List<OrderItemDTO> orderItems;
    private List<DeliveryDTO> deliveries;
}