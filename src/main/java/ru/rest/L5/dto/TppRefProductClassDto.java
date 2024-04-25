package ru.rest.L5.dto;

import jakarta.validation.constraints.NotBlank;

public record TppRefProductClassDto(
        @NotBlank
        Integer internal_id,

        String value,

        String gbi_code,

        String gbi_name,

        String product_row_code,

        String product_row_name,

        String subclass_code,

        String subclass_name
) {
}
