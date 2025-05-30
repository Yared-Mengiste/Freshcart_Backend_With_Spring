package com.shop.freshcart.dto;


import com.shop.freshcart.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSecurityDetailDTO {
    String email;
    String password;
    String Role;

    public UserSecurityDetailDTO(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        //this.Role = user.getRole();
    }


}
