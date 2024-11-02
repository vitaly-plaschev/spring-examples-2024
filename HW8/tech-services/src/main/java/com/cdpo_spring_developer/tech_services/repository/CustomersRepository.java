package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    List<Customers> findAllById(long id);

    List<Customers> findAllByName(String name);

    List<Customers> findAllByMobile(String mobile);

    @Query(nativeQuery = true, value = "SELECT * FROM customers")
    List<Customers> getAllCustomers();

    @Query(nativeQuery = true,
            value = "SELECT * FROM customers " +
                    "WHERE (:name IS NULL OR name = :name) OR " +
                    "(:mobile IS NULL OR mobile = :mobile)")
    List<Customers> findByFilter(String name, String mobile);
}
