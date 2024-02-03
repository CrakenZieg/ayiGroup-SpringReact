package com.ayigroup.evaluacion.error.controller;

import com.ayigroup.evaluacion.error.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionDTO handleException(Exception ex) {
        return new ExceptionDTO(ex.getMessage());
    }

}
