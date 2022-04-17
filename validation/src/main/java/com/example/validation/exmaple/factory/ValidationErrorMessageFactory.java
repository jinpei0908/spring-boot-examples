package com.example.validation.exmaple.factory;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

@Component
public class ValidationErrorMessageFactory {

    public String create(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + "は" + fieldError.getDefaultMessage() + "。")
                .collect(Collectors.joining(""));
    }
}
