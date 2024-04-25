package ru.rest.L5.dto;

import java.util.List;

public record InstanceId(
        String instanceId,
        List<String> registerId,
        List<String> supplementaryAgreementId

) {
}
