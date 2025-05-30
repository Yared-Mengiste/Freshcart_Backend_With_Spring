package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryShopDTO {
    private Long id;
    private String name;
    private String location;
    private String phone;
}