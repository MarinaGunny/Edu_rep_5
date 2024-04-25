package ru.rest.L5.dto;

import java.math.BigDecimal;

public record InstanceArrangement(
        String GeneralAgreementId,
        String SupplementaryAgreementId,
        String arrangementType,
        Integer shedulerJobId,
        String Number,
        String openingDate,
        String closingDate,
        String CancelDate,
        Integer validityDuration,
        String cancellationReason,
        String Status,
        String interestCalculationDate,
        BigDecimal interestRate,
        BigDecimal coefficient,
        String coefficientAction,
        BigDecimal minimumInterestRate,
        BigDecimal minimumInterestRateCoefficient,
        String minimumInterestRateCoefficientAction,
        BigDecimal maximalnterestRate,
        BigDecimal maximalnterestRateCoefficient,
        String maximalnterestRateCoefficientAction
) {
}
