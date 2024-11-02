package com.cdpo_spring_developer.tech_services.mapper;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Customers;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customers mapToEntity(CustomerRequestDTO customerRequest) {
        return Customers.builder()
                .name(customerRequest.name())
                .mobile(customerRequest.mobile())
                .build();
    }

    public CustomerRequestDTO mapToDTO(Customers customers) {
        return new CustomerRequestDTO(
                customers.getName(),
                customers.getMobile()
        );
    }
}
