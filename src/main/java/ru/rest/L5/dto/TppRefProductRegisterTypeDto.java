package ru.rest.L5.dto;

import jakarta.persistence.Column;

public record TppRefProductRegisterTypeDto(
        Integer internal_id,

                String value,

                String register_type_name,

                String product_class_code,

                //Date
                String register_type_start_date,

                //Date
                String register_type_end_date,

                String account_type
) {
}
