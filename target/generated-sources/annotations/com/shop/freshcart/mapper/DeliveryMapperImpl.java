package com.shop.freshcart.mapper;

import com.shop.freshcart.dto.DeliveryDTO;
import com.shop.freshcart.dto.DeliveryResponseDTO;
import com.shop.freshcart.entities.Delivery;
import com.shop.freshcart.entities.Order;
import com.shop.freshcart.entities.Shop;
import com.shop.freshcart.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-30T16:28:34+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public Delivery toEntity(User user, User driver, Shop shop, Order order) {
        if ( user == null && driver == null && shop == null && order == null ) {
            return null;
        }

        Delivery delivery = new Delivery();

        if ( driver != null ) {
            delivery.setDriverId( driver.getId() );
            delivery.setDriverName( driver.getName() );
            delivery.setDriverPhone( driver.getPhoneNo() );
        }
        if ( shop != null ) {
            delivery.setShopName( shop.getName() );
            delivery.setShop( shop );
        }
        if ( order != null ) {
            delivery.setTotalPrice( order.getTotalPrice() );
            delivery.setOrder( order );
        }
        delivery.setUser( user );
        delivery.setCreatedAt( java.time.Instant.now() );
        delivery.setStatus( "PENDING" );

        return delivery;
    }

    @Override
    public DeliveryDTO toResponseDto(Delivery delivery) {
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

    @Override
    public DeliveryResponseDTO toDto(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryResponseDTO deliveryResponseDTO = new DeliveryResponseDTO();

        deliveryResponseDTO.setOrderId( deliveryOrderId( delivery ) );
        deliveryResponseDTO.setUserId( deliveryUserId( delivery ) );
        deliveryResponseDTO.setShopId( deliveryShopId( delivery ) );
        deliveryResponseDTO.setCreatedAt( delivery.getCreatedAt() );
        deliveryResponseDTO.setStatus( delivery.getStatus() );
        deliveryResponseDTO.setDriverId( delivery.getDriverId() );
        deliveryResponseDTO.setDriverName( delivery.getDriverName() );
        deliveryResponseDTO.setShopName( delivery.getShopName() );
        deliveryResponseDTO.setDriverPhone( delivery.getDriverPhone() );
        deliveryResponseDTO.setTotalPrice( delivery.getTotalPrice() );

        return deliveryResponseDTO;
    }

    private Long deliveryOrderId(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }
        Order order = delivery.getOrder();
        if ( order == null ) {
            return null;
        }
        Long id = order.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long deliveryUserId(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }
        User user = delivery.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long deliveryShopId(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }
        Shop shop = delivery.getShop();
        if ( shop == null ) {
            return null;
        }
        Long id = shop.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
