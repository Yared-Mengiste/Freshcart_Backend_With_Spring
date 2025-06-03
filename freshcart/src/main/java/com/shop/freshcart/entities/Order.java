package com.shop.freshcart.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Order_items> orderItems = new ArrayList<>();

//    public void addItem(Order_items item) {
//        orderItems.add(item);
//        item.setOrder(this);
//    }
//
//    public void removeItem(Order_items item) {
//        orderItems.remove(item);
//        item.setOrder(null);
//    }


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries = new ArrayList<>();

//    public void addDelivery(Delivery delivery) {
//        deliveries.add(delivery);
//        delivery.setOrder(this);
//    }
//
//    public void removeDelivery(Delivery delivery) {
//        deliveries.remove(delivery);
//        delivery.setOrder(null);
//    }

}

