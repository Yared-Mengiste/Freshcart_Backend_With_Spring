package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.ProductDTO;
import com.shop.freshcart.dto.UserDTO;
import com.shop.freshcart.entities.Products;
import com.shop.freshcart.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UpdateProductMapper {
    ProductDTO toDto(Products products);

    Products toEntity(ProductDTO dto);

    void updateProductFromDto(ProductDTO dto, @MappingTarget Products entity);
}
