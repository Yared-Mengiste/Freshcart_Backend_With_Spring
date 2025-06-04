package com.shop.freshcart.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemResponseDTO {
    private Long orderId;
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
}
