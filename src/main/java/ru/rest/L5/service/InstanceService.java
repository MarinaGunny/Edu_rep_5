package ru.rest.L5.service;

import jakarta.validation.Valid;
import ru.rest.L5.dto.InstanceRequestDto;
import ru.rest.L5.dto.ResponseInstDto;

public interface InstanceService {

    ResponseInstDto CreateInstance(@Valid InstanceRequestDto dto);
}
