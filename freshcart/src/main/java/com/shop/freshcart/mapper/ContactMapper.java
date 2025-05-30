package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.ContactSubmissionDTO;
import com.shop.freshcart.entities.ContactSubmissions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactSubmissions toEntity(ContactSubmissionDTO dto);

    ContactSubmissionDTO toDto(ContactSubmissions entity);
}