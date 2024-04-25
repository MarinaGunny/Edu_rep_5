package ru.rest.L5.dto;

public record TppProductRegisterDto(
        Integer id,

        String type,
        Integer product_id,

        Integer account,

        String currency_code,

        String state,

        String account_number
) {
}
