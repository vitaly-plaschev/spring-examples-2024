package com.cdpo_spring_developer.tech_services.dto;

import com.cdpo_spring_developer.tech_services.constants.ReservationStatus;

import java.time.LocalDateTime;

public record ReservationsResponseDTO(
        int id,
        String name,
        LocalDateTime registeredAt,
        ReservationStatus status,
        LocalDateTime updated
) {
}
