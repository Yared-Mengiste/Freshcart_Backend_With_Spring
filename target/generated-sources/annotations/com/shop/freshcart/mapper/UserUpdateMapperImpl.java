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
public class UserUpdateMapperImpl implements UserUpdateMapper {

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

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setAccountType( map( userDTO.getAccountType() ) );
        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setAddress( userDTO.getAddress() );
        user.setCity( userDTO.getCity() );
        user.setPhoneNo( userDTO.getPhoneNo() );
        user.setSubcity( userDTO.getSubcity() );
        user.setOwner( userDTO.getOwner() );

        return user;
    }

    @Override
    public void updateUserFromDto(UserDTO dto, User entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getAddress() != null ) {
            entity.setAddress( dto.getAddress() );
        }
        if ( dto.getCity() != null ) {
            entity.setCity( dto.getCity() );
        }
        if ( dto.getPhoneNo() != null ) {
            entity.setPhoneNo( dto.getPhoneNo() );
        }
        if ( dto.getSubcity() != null ) {
            entity.setSubcity( dto.getSubcity() );
        }
        if ( dto.getOwner() != null ) {
            entity.setOwner( dto.getOwner() );
        }
        if ( dto.getAccountType() != null ) {
            entity.setAccountType( map( dto.getAccountType() ) );
        }
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
