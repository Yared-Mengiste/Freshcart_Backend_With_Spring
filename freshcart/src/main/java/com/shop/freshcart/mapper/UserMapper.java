package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.UserDTO;
import com.shop.freshcart.entities.AccountType;
import com.shop.freshcart.entities.User;
import org.mapstruct.*;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "accountType", source = "accountType", qualifiedByName = "stringToAccountType")  // Custom mapping for accountType
    User toEntity(UserDTO dto);

    // Mapping from User to UserDTO (convert AccountType to String)
    @Mapping(target = "accountType", source = "accountType.name")  // Assuming AccountType has a 'name' field
    UserDTO toDto(User user);

    // Custom method to map String to AccountType
    @Named("stringToAccountType")
    default AccountType mapToAccountType(String accountTypeName) {
        if (accountTypeName == null) {
            return new AccountType("1");  // Default to "1" if null
        }
        // If you have a lookup for account types (e.g., in a database), replace the following logic
        AccountType accountType = new AccountType();
        accountType.setName(accountTypeName);  // Assuming AccountType has a 'setName' method
        return accountType;
    }
}
