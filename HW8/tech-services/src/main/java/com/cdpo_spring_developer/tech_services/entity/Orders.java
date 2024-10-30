package com.cdpo_spring_developer.tech_services.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "is_completed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isCompleted;

    @Column(name = "date_at")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customerId;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Services serviceId;

}
