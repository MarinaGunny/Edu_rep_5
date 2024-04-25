package ru.rest.L5.dto;


import java.math.BigDecimal;
import java.util.List;

public record InstanceRequestDto(
        Integer instanceId,

        String productType,

        String productCode,

        String registerType,

        String mdmCode,

        String contractNumber,

        String contractDate,

        Integer priority,

        Double interestRatePenalty,

        Double minimalBalance,

        BigDecimal thresholdAmount,

        String accountingDetails,

        String rateType,

        BigDecimal taxPercentageRate,

        Double technicalOverdraftLimitAmount,

        Integer contractId,

        String BranchCode,

        String IsoCurrencyCode,

        String urgencyCode,

        Integer ReferenceCode,

        List<InstanceArrangement> instanceArrangement


) {
}
