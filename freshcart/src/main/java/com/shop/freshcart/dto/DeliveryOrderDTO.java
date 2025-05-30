package com.shop.freshcart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private List<DeliveryOrderItemDTO> items;
}