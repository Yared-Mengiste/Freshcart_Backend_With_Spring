package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.OrderItemDTO;
import com.shop.freshcart.dto.OrderRequestDTO;
import com.shop.freshcart.dto.OrderResponseDTO;
import com.shop.freshcart.entities.Order;
import com.shop.freshcart.entities.Order_items;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
//DeliveryMapper.class

@Mapper(componentModel = "spring")
public interface OrderCreateMapper {

    @Mapping(source = "userId", target = "user.id") // optional, but you're setting user manually now
    Order toEntity(OrderRequestDTO orderRequestDTO);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "orderItems", target = "orderItems") // if not using ignore strategy
    OrderResponseDTO toResponseDto(Order order);

}

