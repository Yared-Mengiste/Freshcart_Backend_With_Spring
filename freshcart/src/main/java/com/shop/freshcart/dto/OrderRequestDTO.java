package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class OrderRequestDTO {
    private Long userId;
    private double totalPrice;
    private LocalDateTime createdAt;
    private String status;
    private List<OrderItemDTO> items;


}
