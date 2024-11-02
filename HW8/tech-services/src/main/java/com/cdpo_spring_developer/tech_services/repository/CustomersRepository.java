package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    List<Customers> findAllById(long id);

    List<Customers> findAllByName(String name);

    List<Customers> findAllByMobile(String mobile);

    @Query(nativeQuery = true, value = "SELECT * FROM CUSTOMERS")
    List<Customers> getAllCustomers();
}
