package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.ProductDTO;
import com.shop.freshcart.dto.ProductResponseDTO;
import com.shop.freshcart.entities.Products;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-30T16:28:34+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AddProductMapperImpl implements AddProductMapper {

    @Override
    public ProductResponseDTO toResponseDto(Products product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId( product.getId() );
        productResponseDTO.setName( product.getName() );
        productResponseDTO.setPrice( product.getPrice() );
        productResponseDTO.setImg( product.getImg() );
        productResponseDTO.setStock( product.getStock() );

        return productResponseDTO;
    }

    @Override
    public Products toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Products products = new Products();

        products.setCategory( mapCategoryIdToCategory( dto.getCategoryId() ) );
        products.setName( dto.getName() );
        if ( dto.getPrice() != null ) {
            products.setPrice( dto.getPrice() );
        }
        products.setImg( dto.getImg() );
        products.setStock( dto.getStock() );

        return products;
    }
}
