package ru.rest.L5.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record TppProductRegisterRequestDto(

        Integer instanceId,

        String registryTypeCode,

        String accountType,

        @Size(min = 0, max = 3)
        String currencyCode,

        String branchCode,

        String priorityCode,

        String mdmCode,

        String clientCode,

        String trainRegion,

        String counter,

        String salesCode

) {
}
