package com.example.validation.exmaple.controller;

import com.example.validation.exmaple.domain.User;
import com.example.validation.exmaple.factory.ValidationErrorMessageFactory;
import com.example.validation.exmaple.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1")
public class ValidationExampleController {

    private final ValidationErrorMessageFactory errorMessageFactory;
    private final UserValidator userValidator;

    @GetMapping(value = "users")
    public User getUsers(@ModelAttribute @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var message = errorMessageFactory.create(bindingResult);
            throw new ConstraintViolationException(message, null);
        }
        return new User();
    }

    @GetMapping(value = "complicated-users")
    public User getUser(@ModelAttribute User user) {
        userValidator.validate(user);
        return new User();
    }
}
