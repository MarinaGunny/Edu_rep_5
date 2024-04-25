package ru.rest.L5.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record AgreementDto(
        @NotBlank
        Integer id,
        Integer product_id,
        String general_agreement_id,
        String supplementary_agreement_id,
        String arrangement_type,
        Integer sheduler_job_id,
        String number,
        String opening_date,
        String closing_date,
        String cancel_date,
        Integer validity_duration,
        String cancellation_reason,
        String status,
        String interest_calculation_date,
        BigDecimal interest_rate,
        BigDecimal coefficient,
        String coefficient_action,
        BigDecimal minimum_interest_rate,
        BigDecimal minimum_interest_rate_coefficient,
        String minimum_interest_rate_coefficient_action,
        BigDecimal maximal_interest_rate,
        BigDecimal maximal_interest_rate_coefficient,
        String maximal_interest_rate_coefficient_action) {
}
