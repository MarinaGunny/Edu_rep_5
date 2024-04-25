package ru.rest.L5.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.exceptions.NotFoundException;

// Списано. Изучить ResponseEntityExceptionHandler. Работает после аннотаций сам
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    //Не называть классы как аннотации
    @ExceptionHandler(BadReqEcxeption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> exBadRec(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> exNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> exInternalServer(RuntimeException ex, WebRequest request) {

        StackTraceElement[] list = ex.getStackTrace();
        String strLog = "";

        for (StackTraceElement e: list) {
            strLog += e.getClassName() + ":" + e.getMethodName();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage() + strLog);
    }
}
