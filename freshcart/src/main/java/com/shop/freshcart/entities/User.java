package com.shop.freshcart.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "subcity")
    private String subcity;

    @Column(name = "owner")
    private String owner;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_type", referencedColumnName = "id")
    private AccountType accountType;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

//    public void addOrder(Orders  order) {
//        orders.add(order);
//        order.setUser(this);
//    }
//
//    public void removeOrder(Orders order) {
//        orders.remove(order);
//        order.setUser(null);
//    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries = new ArrayList<>();



//    public void addDelivery(Delivery delivery) {
//        deliveries.add(delivery);
//        delivery.setUser(this);
//    }
//
//    public void removeDelivery(Delivery delivery) {
//        deliveries.remove(delivery);
//        delivery.setUser(null);
//    }
}
