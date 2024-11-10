package com.cdpo_spring_developer.tech_services.service;

import com.cdpo_spring_developer.tech_services.dto.OrderRequestDTO;
import com.cdpo_spring_developer.tech_services.entity.Orders;
import com.cdpo_spring_developer.tech_services.mapper.OrderMapper;
import com.cdpo_spring_developer.tech_services.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderMapper orderMapper;

    public List<OrderRequestDTO> getAllOrders() {
        List<Orders> orders = ordersRepository.getAllOrders();
        return orders.stream().map(orderMapper::mapToDTO).toList();
    }
}
