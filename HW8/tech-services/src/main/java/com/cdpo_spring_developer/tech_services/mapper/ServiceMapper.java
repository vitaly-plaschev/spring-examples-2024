package com.cdpo_spring_developer.tech_services.mapper;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.ServiceRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Customers;
import com.cdpo_spring_developer.tech_services.entity.Services;
import org.springframework.stereotype.Service;

@Service
public class ServiceMapper {
    public Services mapToEntity(ServiceRequestDTO serviceRequest) {
        return Services.builder()
                .name(serviceRequest.name())
                .price(serviceRequest.price())
                .build();
    }

    public ServiceRequestDTO mapToDTO(Services services) {
        return new ServiceRequestDTO(
                services.getName(),
                services.getPrice()
        );
    }
}

