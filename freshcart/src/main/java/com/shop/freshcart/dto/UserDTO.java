package com.shop.freshcart.dto;


import com.shop.freshcart.entities.AccountType;
import com.shop.freshcart.entities.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String address;
    private String phoneNo;
    private String subcity;
    private String owner;
    private String accountType;


    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.city = user.getCity();
        this.address = user.getAddress();
        this.phoneNo = user.getPhoneNo();
        this.subcity = user.getSubcity();
        this.owner = user.getEmail();

        AccountType accountTypeEntity = user.getAccountType();
        Long accountTypeId = (accountTypeEntity != null) ? accountTypeEntity.getId() : null;
        this.accountType = resolveAccountType(accountTypeId);
    }

    private String resolveAccountType(Long accountType) {
        if (accountType == null) {
            return "USER";
        }

        int id = accountType.intValue();
        return switch (id) {
            case 2 -> "ADMIN";
            case 3 -> "DRIVER";
            default -> "USER";
        };
    }
}
