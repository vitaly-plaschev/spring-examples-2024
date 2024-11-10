package com.cdpo_spring_developer.tech_services.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record OrderRequestDTO(
        LocalDateTime date,

        @Positive
        Long customerId,

        @Positive
        Long serviceId
) {
}
