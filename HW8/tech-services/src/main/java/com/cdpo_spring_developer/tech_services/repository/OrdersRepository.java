package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Orders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(nativeQuery = true, value = "SELECT * from orders")
    List<Orders> getAllOrders();

    @Query(nativeQuery = true,
            value = "SELECT * FROM orders " +
                    "WHERE (:customerId IS NULL OR customer_id = :customerId) OR " +
                    "(:serviceId IS NULL OR service_id = :serviceId)")
    List<Orders> findByFilter(Long customerId, Long serviceId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM orders WHERE id = :id")
    void customDeleteOrder(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE orders " +
                    "SET date_at = :date, customer_id = :customerId, service_id = :serviceId " +
                    "WHERE id = :id ")
    void customUpdateOrder(Long id, LocalDateTime date, Long customerId, Long serviceId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO orders (date_at, customer_id, service_id) VALUES " +
            "(:date, :customerId, :serviceId)")
    void customRegisterOrder(LocalDateTime date, Long customerId, Long serviceId);

//    @Query(nativeQuery = true,
//            value = "SELECT * FROM orders " +
//                    "WHERE is_completed = false AND " +
//                    "(date_at > :from AND date_at < :to)")
//    List<Orders> findAllReservations(LocalDateTime from, LocalDateTime to);
}
