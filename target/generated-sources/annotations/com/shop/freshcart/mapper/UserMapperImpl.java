package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.UserDTO;
import com.shop.freshcart.entities.AccountType;
import com.shop.freshcart.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-30T16:28:34+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setAccountType( mapToAccountType( dto.getAccountType() ) );
        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setAddress( dto.getAddress() );
        user.setCity( dto.getCity() );
        user.setPhoneNo( dto.getPhoneNo() );
        user.setSubcity( dto.getSubcity() );
        user.setOwner( dto.getOwner() );

        return user;
    }

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setAccountType( userAccountTypeName( user ) );
        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setCity( user.getCity() );
        userDTO.setAddress( user.getAddress() );
        userDTO.setPhoneNo( user.getPhoneNo() );
        userDTO.setSubcity( user.getSubcity() );
        userDTO.setOwner( user.getOwner() );

        return userDTO;
    }

    private String userAccountTypeName(User user) {
        if ( user == null ) {
            return null;
        }
        AccountType accountType = user.getAccountType();
        if ( accountType == null ) {
            return null;
        }
        String name = accountType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
