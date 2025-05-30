package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {
    //
//    private Long id;
    private Instant createdAt;
    private String status;
    private Long driverId;
    private String driverName;
    private String shopName;
    private String driverPhone;
    private Double totalPrice;


//    private Long orderId;
//    private Long userId;
//    private Long shopId; // Uncomment if needed

}
