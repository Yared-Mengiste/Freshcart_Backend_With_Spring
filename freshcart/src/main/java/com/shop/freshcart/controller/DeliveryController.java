package com.shop.freshcart.controller;

import com.shop.freshcart.dto.DeliveryDTO;
import com.shop.freshcart.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getDeliveriesByUser(@PathVariable Long userId) {
        return deliveryService.getDeliveriesByUserId(userId);
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<?> getDeliveriesByDriver(@PathVariable Long driverId) {
        return deliveryService.getDeliveriesByDriverId(driverId);
    }
}