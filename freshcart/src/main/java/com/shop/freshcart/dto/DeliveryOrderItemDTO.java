package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderItemDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
}
