package com.example.validation.exmaple.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {

    private String errorMessage;
}
