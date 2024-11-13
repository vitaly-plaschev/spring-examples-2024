package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.OrderRequestDTO;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.service.OrdersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {
    private final OrdersService ordersService;

    @GetMapping(path = "/all", produces = "application/json")
    public List<OrderRequestDTO> getAllOrders() {
        log.info("GET request with all orders");
        return ordersService.getAllOrders();
    }

    @GetMapping(path = "/filter", produces = "application/json")
    public List<OrderRequestDTO> getOrderByFilter(
            @Positive @RequestParam(required = false) Long customerId,
            @Positive @RequestParam(required = false) Long serviceId) {
        if ((customerId == null) && (serviceId == null)) {
            throw new CustomerException(HttpStatus.BAD_REQUEST, "Customer id or Service Id should be specified");
        }
        return ordersService.getOrderByFilter(customerId, serviceId);
    }

    @PostMapping()
    public ResponseEntity<?> registerOrder(@Valid @RequestBody OrderRequestDTO orderRequest, HttpServletRequest request) {
        log.debug("POST request. Order: {}", orderRequest);
        ordersService.registerOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path="/complete")
    public ResponseEntity<?> completeOrder(@Positive @RequestParam Long id) {
        log.debug("Complete request. Order: {}", id);
        ordersService.completeOrder(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteOrder(@Positive @RequestParam Long id) {
        log.debug("DELETE request. Order: {}", id);
        ordersService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping()
    public ResponseEntity<?> updateOrder(@Positive @RequestParam Long id, @RequestBody OrderRequestDTO orderRequest) {
        log.debug("UPDATE request. Order: {}", id);
        ordersService.updateOrder(id, orderRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
