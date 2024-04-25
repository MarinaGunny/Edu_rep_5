package ru.rest.L5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


//Списано. Изучить подробнее ResponseStatusException
public class BadReqEcxeption extends ResponseStatusException {
    public BadReqEcxeption(String ErrMessage) {super(HttpStatus.BAD_REQUEST, ErrMessage);}
}
