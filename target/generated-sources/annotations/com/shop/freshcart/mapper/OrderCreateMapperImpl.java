package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.DeliveryDTO;
import com.shop.freshcart.dto.OrderItemDTO;
import com.shop.freshcart.dto.OrderRequestDTO;
import com.shop.freshcart.dto.OrderResponseDTO;
import com.shop.freshcart.entities.Delivery;
import com.shop.freshcart.entities.Order;
import com.shop.freshcart.entities.Order_items;
import com.shop.freshcart.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-30T16:28:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderCreateMapperImpl implements OrderCreateMapper {

    @Override
    public Order toEntity(OrderRequestDTO orderRequestDTO) {
        if ( orderRequestDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setUser( orderRequestDTOToUser( orderRequestDTO ) );
        order.setTotalPrice( orderRequestDTO.getTotalPrice() );
        order.setCreatedAt( orderRequestDTO.getCreatedAt() );
        order.setStatus( orderRequestDTO.getStatus() );

        return order;
    }

    @Override
    public OrderResponseDTO toResponseDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setUserId( orderUserId( order ) );
        orderResponseDTO.setOrderItems( order_itemsListToOrderItemDTOList( order.getOrderItems() ) );
        orderResponseDTO.setId( order.getId() );
        orderResponseDTO.setTotalPrice( order.getTotalPrice() );
        orderResponseDTO.setStatus( order.getStatus() );
        orderResponseDTO.setCreatedAt( order.getCreatedAt() );
        orderResponseDTO.setDeliveries( deliveryListToDeliveryDTOList( order.getDeliveries() ) );

        return orderResponseDTO;
    }

    protected User orderRequestDTOToUser(OrderRequestDTO orderRequestDTO) {
        if ( orderRequestDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( orderRequestDTO.getUserId() );

        return user;
    }

    private Long orderUserId(Order order) {
        if ( order == null ) {
            return null;
        }
        User user = order.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected OrderItemDTO order_itemsToOrderItemDTO(Order_items order_items) {
        if ( order_items == null ) {
            return null;
        }

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        if ( order_items.getQuantity() != null ) {
            orderItemDTO.setQuantity( order_items.getQuantity() );
        }
        if ( order_items.getPrice() != null ) {
            orderItemDTO.setPrice( order_items.getPrice() );
        }

        return orderItemDTO;
    }

    protected List<OrderItemDTO> order_itemsListToOrderItemDTOList(List<Order_items> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemDTO> list1 = new ArrayList<OrderItemDTO>( list.size() );
        for ( Order_items order_items : list ) {
            list1.add( order_itemsToOrderItemDTO( order_items ) );
        }

        return list1;
    }

    protected DeliveryDTO deliveryToDeliveryDTO(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryDTO deliveryDTO = new DeliveryDTO();

        deliveryDTO.setCreatedAt( delivery.getCreatedAt() );
        deliveryDTO.setStatus( delivery.getStatus() );
        deliveryDTO.setDriverId( delivery.getDriverId() );
        deliveryDTO.setDriverName( delivery.getDriverName() );
        deliveryDTO.setShopName( delivery.getShopName() );
        deliveryDTO.setDriverPhone( delivery.getDriverPhone() );
        deliveryDTO.setTotalPrice( delivery.getTotalPrice() );

        return deliveryDTO;
    }

    protected List<DeliveryDTO> deliveryListToDeliveryDTOList(List<Delivery> list) {
        if ( list == null ) {
            return null;
        }

        List<DeliveryDTO> list1 = new ArrayList<DeliveryDTO>( list.size() );
        for ( Delivery delivery : list ) {
            list1.add( deliveryToDeliveryDTO( delivery ) );
        }

        return list1;
    }
}
