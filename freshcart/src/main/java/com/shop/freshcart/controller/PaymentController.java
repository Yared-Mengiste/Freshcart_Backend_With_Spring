package com.shop.freshcart.controller;

import com.shop.freshcart.dto.ChapaPaymentRequest;
import com.shop.freshcart.service.ChapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private ChapaService chapaService;

    // 1. Accept payment request, return Chapa checkout URL
    @PostMapping("/pay")
    public ResponseEntity<String> createPayment(@RequestBody ChapaPaymentRequest paymentRequest) {

        String checkoutUrl = chapaService.initializePayment(paymentRequest);
        return ResponseEntity.ok(checkoutUrl); // Frontend redirects to this
    }

    // 2. Verify payment by tx_ref
    @GetMapping("/verify")
    public ResponseEntity<Map<String, Object>> verifyPayment(@RequestParam String tx_ref) {
        System.out.println("Verifying tx_ref: " + tx_ref);
        Map<String, Object> result = chapaService.verifyPayment(tx_ref);
        return ResponseEntity.ok(result);
    }
}
