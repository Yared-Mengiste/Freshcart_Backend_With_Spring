package com.shop.freshcart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class ContactSubmissionDTO {
    private String name;
    private String email;
    private String message;
    private Instant createdAt;
}
