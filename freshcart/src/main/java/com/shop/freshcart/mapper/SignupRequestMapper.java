package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.SignupRequestDTO;
import com.shop.freshcart.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SignupRequestMapper {

    @Mapping(source = "accountType.name", target = "accountTypeName")
//    @Mapping(target = "accountTypeName", ignore = true)
    SignupRequestDTO toDto(User user);

    @Mapping(target = "accountType", ignore = true)
    User toEntity(SignupRequestDTO dto);
}

