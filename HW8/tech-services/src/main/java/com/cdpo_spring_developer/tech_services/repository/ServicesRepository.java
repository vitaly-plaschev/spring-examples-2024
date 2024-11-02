package com.cdpo_spring_developer.tech_services.repository;

import com.cdpo_spring_developer.tech_services.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Long> {
    @Query(nativeQuery = true, value = "SELECT * from services")
    List<Services> getAllServices();

    List<Services> findAllByName(String name);

}
