package ru.rest.L5.dto;

import jakarta.validation.constraints.NotBlank;
import ru.rest.L5.entity.Account;

import java.util.List;


//TODO ограничения на длину строки
public record AccountPoolDto(
        @NotBlank
        Integer id,
        String branch_code,
        String currency_code,
        String mdm_code,
        String priority_code,
        String registry_type_code,
        List<Account> accounts
) {
}
