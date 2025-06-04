package com.shop.freshcart.service;

import com.shop.freshcart.dto.ChapaPaymentRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ChapaService {

    private final String SECRET_KEY = "Bearer CHASECK_TEST-3x7RozWbvF7Eos43kBf3h3gf02vlQiXF"; // Replace with real key
    private final String INIT_URL = "https://api.chapa.co/v1/transaction/initialize";
    private final String VERIFY_URL = "https://api.chapa.co/v1/transaction/verify/";

    private final RestTemplate restTemplate = new RestTemplate();

    public String initializePayment(ChapaPaymentRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", SECRET_KEY);

        HttpEntity<ChapaPaymentRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                INIT_URL,
                HttpMethod.POST, entity, Map.class
        );

        Map<String, Object> body = response.getBody();

        if (body != null && body.get("data") instanceof Map) {
            Map<String, Object> data = (Map<String, Object>) body.get("data");
            return (String) data.get("checkout_url");
        } else {
            throw new RuntimeException("Failed to retrieve Chapa checkout_url.");
        }
    }


    public Map<String, Object> verifyPayment(String txRef) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", SECRET_KEY);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    VERIFY_URL + txRef,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<>() {}
            );

            return response.getBody();
        } catch (Exception e) {
            System.err.println("Payment verification failed: " + e.getMessage());
            throw new RuntimeException("Payment verification error", e);
        }
    }


}
