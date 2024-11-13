package com.cdpo_spring_developer.tech_services.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ReservationPeriodDTO(
        @NotNull
        LocalDateTime from,

        @NotNull
        LocalDateTime to
) {
}
