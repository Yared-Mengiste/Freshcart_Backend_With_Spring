package com.shop.freshcart.dto;

import lombok.Data;

@Data
public class ChapaPaymentRequest {
    private String amount;
    private String currency = "ETB";
    private String email;
    private String first_name;
    private String last_name;
    private String tx_ref;
    private String callback_url;
    private String return_url;
    private Customization customization;

    @Data
    public static class Customization {
        private String title;
        private String description;
    }
}
