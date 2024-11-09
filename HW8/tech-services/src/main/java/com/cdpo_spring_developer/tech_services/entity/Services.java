package com.cdpo_spring_developer.tech_services.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name="services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    public Services(long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Services(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Services(String name) {
        this.name = name;
    }

    public Services(Double price) {
        this.price = price;
    }

    public Services(Long id) {
        this.id = id;
    }

    public Services() {
    }
}
