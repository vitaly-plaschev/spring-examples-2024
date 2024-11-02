package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.service.CustomersService;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Validated
@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {

    private final CustomersService customersService;

    public CustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping(path="/all", produces = "application/json")
    public List<CustomerRequestDTO> getAllCustomers() {
        log.info("GET request with all customers");
        return customersService.getAllCustomers();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<CustomerRequestDTO> getCustomerById(@Positive @RequestParam int id) {
        log.info("GET request with customer ID = {}", id);
        try {
            return new ResponseEntity<>(customersService.getCustomerById(id), HttpStatus.OK);
        } catch (CustomerException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
}
