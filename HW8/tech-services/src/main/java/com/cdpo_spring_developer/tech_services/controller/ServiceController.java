package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.CustomerRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.ServiceRequestDTO;
import com.cdpo_spring_developer.tech_services.exceptions.CustomerException;
import com.cdpo_spring_developer.tech_services.service.ServicesService;
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
@RequestMapping("/api/v1/services")
@RestController
public class ServiceController {
    private final ServicesService servicesService;

    @GetMapping(path = "/all", produces = "application/json")
    public List<ServiceRequestDTO> getAllServices() {
        log.info("GET request with all services");
        return servicesService.getAllServices();
    }

    @GetMapping(path = "/filter", produces = "application/json")
    public List<ServiceRequestDTO> getServicesByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price) {

        if ((name == null || name.isBlank()) && (price == null || price.isNaN())) {
            throw new CustomerException(HttpStatus.BAD_REQUEST, "Name or price should be specified");
        }

        return servicesService.getServiceByFilter(name, price);
    }

    @PostMapping()
    public ResponseEntity<?> registerService(@Valid @RequestBody ServiceRequestDTO servicelRequest, HttpServletRequest request) {
        log.debug("POST request. Service: {}", servicelRequest);
        servicesService.registerService(servicelRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteService(@Positive @RequestParam Long id) {
        log.debug("DELETE request. Service: {}", id);
        servicesService.deleteService(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping()
    public ResponseEntity<?> updateService(@Positive @RequestParam Long id, @RequestBody ServiceRequestDTO servicelRequest) {
        log.debug("UPDATE request. Service: {}", id);
        servicesService.updateService(id, servicelRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
