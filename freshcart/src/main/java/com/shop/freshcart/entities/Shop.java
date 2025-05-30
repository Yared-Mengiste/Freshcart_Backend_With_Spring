package com.shop.freshcart.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "subcity")
    private String subcity;

    @Column(name = "owner")
    private String owner;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;


}

