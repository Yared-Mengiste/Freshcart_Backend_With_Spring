package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.*;
import com.shop.freshcart.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    @Mapping(target = "id", ignore = true) // Ignore this so MapStruct doesn't try to set it
    @Mapping(source = "driver.id", target = "driverId")
    @Mapping(source = "driver.name", target = "driverName")
    @Mapping(source = "driver.phoneNo", target = "driverPhone")
    @Mapping(source = "shop.name", target = "shopName")
    @Mapping(source = "order.totalPrice", target = "totalPrice")
    @Mapping(source = "order", target = "order")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "shop", target = "shop")
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    @Mapping(target = "status", constant = "PENDING")
    Delivery toEntity(User user, User driver, Shop shop, Order order);

//    @Mapping(source = "order.id", target = "orderId")
//    @Mapping(source = "user.id", target = "userId")
//    @Mapping(source = "shop.id", target = "shopId")
    DeliveryDTO toResponseDto(Delivery delivery);

    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "shop.id", target = "shopId")
    DeliveryResponseDTO toDto(Delivery delivery);
}
