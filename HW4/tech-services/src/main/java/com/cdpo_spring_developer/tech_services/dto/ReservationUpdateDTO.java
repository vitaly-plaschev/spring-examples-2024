package com.cdpo_spring_developer.tech_services.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record ReservationUpdateDTO(
        int id,
        @NotNull
        @Past
        LocalDateTime registeredAt
) {
}
