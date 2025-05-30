package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.UserDTO;
import com.shop.freshcart.entities.AccountType;
import com.shop.freshcart.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserUpdateMapper {

    @Mapping(target = "accountType", source = "accountType.name")
    UserDTO toDto(User user);

    // Mapping the String (from UserDTO) to AccountType (for User)
    @Mapping(target = "accountType", source = "accountType")
    User toEntity(UserDTO userDTO);

    // Update method using @MappingTarget
    void updateUserFromDto(UserDTO dto, @MappingTarget User entity);

    default AccountType map(String value) {
        if (value == null) {
            return null;
        }
        // Assuming you have a method to fetch AccountType by its name, modify as needed
        return new AccountType(value);  // Replace with actual logic if needed
    }

    default String map(AccountType accountType) {
        if (accountType == null) {
            return null;
        }
        // Assuming AccountType has a getName() method or similar to return a String
        return accountType.getName();  // Replace with actual logic if needed
    }
}

