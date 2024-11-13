package com.cdpo_spring_developer.tech_services.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "date_at")
    private LocalDateTime date;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_completed")
    private boolean isCompleted;

    public Reservations(Long id, Long orderId, String customerName, String serviceName, LocalDateTime date, Double price, boolean isCompleted) {
        this.id = id;
        this.orderId = orderId;
        this.customerName = customerName;
        this.serviceName = serviceName;
        this.date = date;
        this.price = price;
        this.isCompleted = isCompleted;
    }

    public Reservations() {
    }
}
