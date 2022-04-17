package com.example.validation.exmaple.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


@Data
public class User {

    @NotNull
    @Positive
    private Long id;

    @Size(min = 1)
    private String name;

    @PositiveOrZero
    private Integer age;
}
