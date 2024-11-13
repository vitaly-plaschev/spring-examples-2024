package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
    @Query(nativeQuery = true, value = "select * from reservations")
    List<Reservations> getAllReservations();

    @Query(nativeQuery = true,
            value = "SELECT * FROM reservations " +
                    "WHERE is_completed = false AND " +
                    "(date_at > :from AND date_at < :to)")
    List<Reservations> findAllReservationsForPeriod(LocalDateTime from, LocalDateTime to);

    @Query(nativeQuery = true,
            value = "SELECT * FROM reservations " +
                    "WHERE is_completed = false AND " +
                    "(date_at > :from AND date_at < :to)")
    List<Reservations> findRevenueForPeriod(LocalDateTime from, LocalDateTime to);

    @Query(nativeQuery = true,
            value = "SELECT id, order_id, customer_name, service_name, date_at, price, is_completed, total.total_amount\n" +
                    "FROM reservations r,\n" +
                    "    (\n" +
                    "\t\tSELECT SUM(price) AS total_amount FROM reservations\n" +
                    "\t\tWHERE reservations.is_completed = true AND (reservations.date_at > :from AND reservations.date_at < :to)\n" +
                    "\t) AS total\n" +
                    "WHERE r.is_completed = true AND (r.date_at > :from AND r.date_at < :to)")
    List<Reservations> findTotalRevenueForPeriod(LocalDateTime from, LocalDateTime to);
}
