package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponseDTO {
    //private Long id;
    private Instant createdAt;
    private String status;
    private Long driverId;
    private String driverName;
    private String shopName;
    private String driverPhone;
    private Double totalPrice;

    private Long orderId;
    private Long userId;
    private Long shopId;
}
