package com.shop.freshcart.dto;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignupRequestDTO {
    private String name;
    private String email;
    private String password;
    private String address;
    private String city;
    private String phoneNo;
    private String subcity;
    private String owner;
    private String accountTypeName;
}

