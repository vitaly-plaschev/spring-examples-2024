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
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "is_completed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isCompleted;

    @Column(name = "date_at")
    private LocalDateTime date;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "service_id")
    private Long serviceId;

    public Orders(Long id, boolean isCompleted, LocalDateTime date, Long customerId, Long serviceId) {
        this.id = id;
        this.isCompleted = isCompleted;
        this.date = date;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Orders() {
    }
}
