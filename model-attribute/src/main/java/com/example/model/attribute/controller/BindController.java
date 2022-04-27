package com.example.model.attribute.controller;

import com.example.model.attribute.domain.User;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("v1")
public class BindController {

    @GetMapping("bind-by-model-attribute")
    public User get(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var message = bindingResult.getAllErrors().stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
                            .collect(Collectors.joining(","));
            throw new IllegalArgumentException(message);
        }
        return user;
    }
}
