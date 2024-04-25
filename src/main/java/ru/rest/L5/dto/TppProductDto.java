package ru.rest.L5.dto;


import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record TppProductDto(
        @NotBlank
        Integer id,
        Integer product_code_id,
        Integer client_id,
        String type,
        String number,
        Integer priority,
        String date_of_conclusion,
        String start_date_time,
        String end_date_time,
        Integer days,
        BigDecimal penalty_rate,
        BigDecimal nso,
        BigDecimal threshold_amount,
        String requisite_type,
        String interest_rate_type,
        BigDecimal tax_rate,
        String reasone_close,
        String state
) {
}
