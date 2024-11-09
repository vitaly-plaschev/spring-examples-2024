package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Services;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Long> {
    @Query(nativeQuery = true, value = "SELECT * from services")
    List<Services> getAllServices();

    @Query(nativeQuery = true,
            value = "SELECT * FROM services " +
                    "WHERE (:name IS NULL OR LOWER(name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
                    "(:price IS NULL OR price = :price)")
    List<Services> findByFilter(String name, Double price);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM services WHERE id = :id")
    void customDeleteService(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE services " +
                    "SET name = :name, price = :price " +
                    "WHERE id = :id ")
    void customUpdateServices(Long id, String name, Double price);

}
