package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationUpdateDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationsResponseDTO;
import com.cdpo_spring_developer.tech_services.service.ReservationsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationsController {
    @Autowired
    private ReservationsService service;

    @GetMapping("/all")
    public List<ReservationsResponseDTO> getAllReservations() {
        return service.getAllReservations();
    }

    @PostMapping("/create")
    public ReservationsResponseDTO createReservation(@Valid @RequestBody ReservationRequestDTO req) {
        return service.save(req);
    }

    @DeleteMapping("/delete/{id}")
    public void getServiceById(@Positive @PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/update")
    public void updateReservation(@Valid @RequestBody ReservationUpdateDTO req) {
        service.update(req);
    }

}
