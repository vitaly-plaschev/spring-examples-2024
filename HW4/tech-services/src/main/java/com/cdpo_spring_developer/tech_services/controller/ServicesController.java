package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.TechServiceDTO;
import com.cdpo_spring_developer.tech_services.service.TechServiceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {
    @Autowired
    TechServiceService service;

    @PostMapping("/create")
    public TechServiceDTO createService(@Valid @RequestBody TechServiceDTO req) {
        return service.save(req);
    }

    @GetMapping("/all")
    public List<TechServiceDTO> getAllServices() {
        return service.getAllServices();
    }

    @GetMapping("/{serviceId}")
    public TechServiceDTO getServiceById(@Positive @PathVariable int serviceId) {
        return service.findById(serviceId);
    }
}
