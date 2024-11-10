package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.OrderRequestDTO;
import com.cdpo_spring_developer.tech_services.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {
    private final OrdersService customersOrder;

    @GetMapping(path = "/all", produces = "application/json")
    public List<OrderRequestDTO> getAllOrders() {
        log.info("GET request with all orders");
        return customersOrder.getAllOrders();
    }
}
