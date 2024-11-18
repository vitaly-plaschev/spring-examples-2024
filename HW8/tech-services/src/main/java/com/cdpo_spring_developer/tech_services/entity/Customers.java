package com.cdpo_spring_developer.tech_services.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile")
    private String mobile;

    public Customers(long id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public Customers(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public Customers(String name) {
        this.name = name;
    }

    public Customers(Long id) {
        this.id = id;
    }

    public Customers() {
    }
}
