package com.example.validation.exmaple.validator;

import com.example.validation.exmaple.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(User user) {
        var violations = validator.validate(user);
        var stringBuilder = new StringBuilder();
        var violationMessages = violations.stream()
                        .map(violation -> violation.getPropertyPath().toString() + "は" + violation.getMessage() + "。")
                        .collect(Collectors.joining(""));
        stringBuilder.append(violationMessages);

        if (user.getName() == null && user.getAge() == null) {
            stringBuilder.append("nameかageのどちらかは指定してください。");
        }

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
