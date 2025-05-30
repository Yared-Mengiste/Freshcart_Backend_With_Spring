package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.UserSecurityDetailDTO;
import com.shop.freshcart.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityDetailMapper {

    public UserSecurityDetailDTO toDto(User user) {
        UserSecurityDetailDTO dto = new UserSecurityDetailDTO();
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        //dto.setRole(user.getRole()); // Ensure this is not null
        return dto;
    }

    public UserDetails toUserDetails(UserSecurityDetailDTO dto) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(dto.getEmail()) // Email used as username
                .password(dto.getPassword())
                .roles(dto.getRole().replace("ROLE_", ""))
                .build();
    }
}
