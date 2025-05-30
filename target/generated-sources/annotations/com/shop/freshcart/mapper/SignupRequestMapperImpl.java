package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.SignupRequestDTO;
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
public class SignupRequestMapperImpl implements SignupRequestMapper {

    @Override
    public SignupRequestDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();

        signupRequestDTO.setAccountTypeName( userAccountTypeName( user ) );
        signupRequestDTO.setName( user.getName() );
        signupRequestDTO.setEmail( user.getEmail() );
        signupRequestDTO.setPassword( user.getPassword() );
        signupRequestDTO.setAddress( user.getAddress() );
        signupRequestDTO.setCity( user.getCity() );
        signupRequestDTO.setPhoneNo( user.getPhoneNo() );
        signupRequestDTO.setSubcity( user.getSubcity() );
        signupRequestDTO.setOwner( user.getOwner() );

        return signupRequestDTO;
    }

    @Override
    public User toEntity(SignupRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setAddress( dto.getAddress() );
        user.setCity( dto.getCity() );
        user.setPhoneNo( dto.getPhoneNo() );
        user.setSubcity( dto.getSubcity() );
        user.setOwner( dto.getOwner() );

        return user;
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
