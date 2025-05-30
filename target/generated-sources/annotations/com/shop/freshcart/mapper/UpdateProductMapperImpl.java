package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.ProductDTO;
import com.shop.freshcart.entities.Products;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-30T16:28:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UpdateProductMapperImpl implements UpdateProductMapper {

    @Override
    public ProductDTO toDto(Products products) {
        if ( products == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName( products.getName() );
        productDTO.setPrice( products.getPrice() );
        productDTO.setImg( products.getImg() );
        productDTO.setStock( products.getStock() );

        return productDTO;
    }

    @Override
    public Products toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Products products = new Products();

        products.setName( dto.getName() );
        if ( dto.getPrice() != null ) {
            products.setPrice( dto.getPrice() );
        }
        products.setImg( dto.getImg() );
        products.setStock( dto.getStock() );

        return products;
    }

    @Override
    public void updateProductFromDto(ProductDTO dto, Products entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getPrice() != null ) {
            entity.setPrice( dto.getPrice() );
        }
        if ( dto.getImg() != null ) {
            entity.setImg( dto.getImg() );
        }
        if ( dto.getStock() != null ) {
            entity.setStock( dto.getStock() );
        }
    }
}
