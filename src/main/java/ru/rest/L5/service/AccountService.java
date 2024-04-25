package ru.rest.L5.service;

import jakarta.validation.Valid;
import ru.rest.L5.dto.ResponseDto;
import ru.rest.L5.dto.TppProductRegisterDto;
import ru.rest.L5.dto.TppProductRegisterRequestDto;
import ru.rest.L5.entity.TppProductRegister;

import java.util.Optional;

public interface AccountService {

    Optional<TppProductRegister> GetById(Integer Id);

    //Создаем на основе JSON, поэтому входящий DTO
    ResponseDto CreateAccount(@Valid TppProductRegisterRequestDto dto);
}
