package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemDTO {
    private Long orderId;
    private Long productId;
    private int quantity;
    private double price;
}
