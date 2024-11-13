package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
    @Query(nativeQuery = true, value = "select * from reservations")
    List<Reservations> getAllReservations();
}
