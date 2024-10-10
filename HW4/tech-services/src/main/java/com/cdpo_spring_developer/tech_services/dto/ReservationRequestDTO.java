package com.cdpo_spring_developer.tech_services.dto;

import com.cdpo_spring_developer.tech_services.constants.ReservationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record ReservationRequestDTO(
        @NotEmpty
        @NotBlank
        String name,

        @NotNull
        @Past
        LocalDateTime registeredAt,

        ReservationStatus status
) {
}
