package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.service.CustomersService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/all", produces = "application/json")
    public List<CustomerRequestDTO> getAllCustomers() {
        log.info("GET request with all customers");
        return customersService.getAllCustomers();
    }

    @GetMapping(path = "/find", produces = "application/json")
    public List<CustomerRequestDTO> getCustomersByParam(@Valid @RequestParam String name) {
        if (name.isBlank()) throw new CustomerException(HttpStatus.BAD_REQUEST, "Name or mobile should be specified");
        return customersService.getCustomerByName(name);
    }

    @GetMapping(path = "/filter", produces = "application/json")
    public List<CustomerRequestDTO> getCustomersByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String mobile) {
        if (name == null || name.isBlank() && mobile == null || mobile.isBlank()) {
            throw new CustomerException(HttpStatus.BAD_REQUEST, "Name or mobile should be specified");
        }
        return customersService.getCustomerByFilter(name, mobile);
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
