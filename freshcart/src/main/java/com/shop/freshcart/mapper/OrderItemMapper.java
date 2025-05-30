package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.OrderItemDTO;
import com.shop.freshcart.entities.Order_items;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(source = "productId", target = "product.id")
    Order_items toEntity(OrderItemDTO orderItemDTO);

    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "product.id", target = "productId")
    OrderItemDTO toDto(Order_items orderItems);
}
