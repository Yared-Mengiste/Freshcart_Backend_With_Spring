package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.OrderItemDTO;
import com.shop.freshcart.entities.Order;
import com.shop.freshcart.entities.Order_items;
import com.shop.freshcart.entities.Products;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-30T16:28:34+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public Order_items toEntity(OrderItemDTO orderItemDTO) {
        if ( orderItemDTO == null ) {
            return null;
        }

        Order_items order_items = new Order_items();

        order_items.setProduct( orderItemDTOToProducts( orderItemDTO ) );
        order_items.setQuantity( orderItemDTO.getQuantity() );
        order_items.setPrice( orderItemDTO.getPrice() );

        return order_items;
    }

    @Override
    public OrderItemDTO toDto(Order_items orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setOrderId( orderItemsOrderId( orderItems ) );
        orderItemDTO.setProductId( orderItemsProductId( orderItems ) );
        if ( orderItems.getQuantity() != null ) {
            orderItemDTO.setQuantity( orderItems.getQuantity() );
        }
        if ( orderItems.getPrice() != null ) {
            orderItemDTO.setPrice( orderItems.getPrice() );
        }

        return orderItemDTO;
    }

    protected Products orderItemDTOToProducts(OrderItemDTO orderItemDTO) {
        if ( orderItemDTO == null ) {
            return null;
        }

        Products products = new Products();

        products.setId( orderItemDTO.getProductId() );

        return products;
    }

    private Long orderItemsOrderId(Order_items order_items) {
        if ( order_items == null ) {
            return null;
        }
        Order order = order_items.getOrder();
        if ( order == null ) {
            return null;
        }
        Long id = order.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long orderItemsProductId(Order_items order_items) {
        if ( order_items == null ) {
            return null;
        }
        Products product = order_items.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
