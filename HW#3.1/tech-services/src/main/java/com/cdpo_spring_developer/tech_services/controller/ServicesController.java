package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.TechServiceDTO;
import com.cdpo_spring_developer.tech_services.service.TechServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {
    @Autowired
    TechServiceService service;

    @PostMapping("/create")
    public TechServiceDTO createService(@RequestBody TechServiceDTO req) {
        return service.save(req);
    }

    @GetMapping("/all")
    public List<TechServiceDTO> getAllCustomers() {
        return service.getAllServices();
    }

    @GetMapping("/{serviceId}")
    public TechServiceDTO getCustomerById(@PathVariable int serviceId) {
        return service.findById(serviceId);
    }
}
