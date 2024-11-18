package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Customers;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM customers WHERE id = :id")
    void customDeleteCustomer(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE customers " +
                    "SET name = :name, mobile = :mobile " +
                    "WHERE id = :id ")
    void customUpdateCustomer(Long id, String name, String mobile);
}
