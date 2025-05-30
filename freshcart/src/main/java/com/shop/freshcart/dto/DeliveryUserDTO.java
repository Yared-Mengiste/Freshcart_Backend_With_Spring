package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryUserDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
}
