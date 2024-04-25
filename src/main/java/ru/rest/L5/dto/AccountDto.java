package ru.rest.L5.dto;

import ru.rest.L5.entity.AccountPool;
import jakarta.validation.constraints.NotBlank;

public record AccountDto(
        @NotBlank
        Integer id,
        String account_number,
        boolean bussy,
        AccountPool account_pool_id
) {}
