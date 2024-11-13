package com.cdpo_spring_developer.tech_services.controller;

import com.cdpo_spring_developer.tech_services.dto.ReservationPeriodDTO;
import com.cdpo_spring_developer.tech_services.dto.ReservationRequestDTO;
import com.cdpo_spring_developer.tech_services.service.ReservationsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservations")
@RestController
public class ReservationController {
    private final ReservationsService reservationsService;

    @GetMapping(path = "/all", produces = "application/json")
    public List<ReservationRequestDTO> getAllReservations() {
        log.info("GET request with all reservations");
        return reservationsService.getAllReservations();
    }

    @GetMapping(path = "/period", produces = "application/json")
    public List<ReservationRequestDTO> getAllReservationsForPeriod(@Valid @RequestBody ReservationPeriodDTO periodRequest) {
        log.info("GET request with all reservations for specified period");
        return reservationsService.getAllReservationsForPeriod(periodRequest);
    }

    @GetMapping(path = "/period/revenue", produces = "application/json")
    public List<ReservationRequestDTO> getReservationsTotalRevenueForPeriod(@Valid @RequestBody ReservationPeriodDTO periodRequest) {
        log.info("GET request with total reservations revenue for specified period");
        return reservationsService.getReservationsTotalRevenueForPeriod(periodRequest);
    }
}
