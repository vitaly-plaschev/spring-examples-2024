package com.cdpo_spring_developer.tech_services.mapper;

import com.cdpo_spring_developer.tech_services.dto.OrderRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Orders;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Orders mapToEntity(OrderRequestDTO orderRequest) {
        return Orders.builder()
                .date(orderRequest.date())
                .customerId(orderRequest.customerId())
                .serviceId(orderRequest.serviceId())
                .build();
    }

    public OrderRequestDTO mapToDTO(Orders orders) {
        return new OrderRequestDTO(
                orders.getDate(),
                orders.getCustomerId(),
                orders.getServiceId()
        );
    }
}