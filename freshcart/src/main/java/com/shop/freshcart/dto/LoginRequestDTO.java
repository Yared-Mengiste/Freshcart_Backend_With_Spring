package com.shop.freshcart.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginRequestDTO {
    private String email;
    private String password;
}
