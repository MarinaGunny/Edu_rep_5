package ru.rest.L5.dto;

import jakarta.validation.constraints.NotBlank;

public record TppRefAccountTypeDto(

        @NotBlank
        Integer internal_id,

        String value
) {
}
