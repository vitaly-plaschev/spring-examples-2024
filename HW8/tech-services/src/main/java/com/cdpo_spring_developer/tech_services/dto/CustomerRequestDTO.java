package com.cdpo_spring_developer.tech_services.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CustomerRequestDTO(
        @NotBlank
        @NotEmpty
        String name,

        @NotBlank
        @NotEmpty
        String mobile
) {

}
