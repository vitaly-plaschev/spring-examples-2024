package com.cdpo_spring_developer.tech_services.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ServiceRequestDTO(
        @NotBlank
        @NotEmpty
        String name,

        @Positive
        Double price
) {

}
