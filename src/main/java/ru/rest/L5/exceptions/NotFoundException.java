package ru.rest.L5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(String ErrMessage) {super(HttpStatus.NOT_FOUND, ErrMessage);}
}
