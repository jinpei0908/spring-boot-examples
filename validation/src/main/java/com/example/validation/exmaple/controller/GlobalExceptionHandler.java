package com.example.validation.exmaple.controller;

import com.example.validation.exmaple.domain.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Error handleControllerException(IllegalArgumentException ex) {
        return Error.builder()
                .errorMessage(ex.getMessage())
                .build();
    }
}
