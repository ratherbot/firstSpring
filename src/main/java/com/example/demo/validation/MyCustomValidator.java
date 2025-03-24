package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyCustomValidator implements ConstraintValidator<MyCustomConstraint, String> {

    @Override
    public void initialize(MyCustomConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return Character.isUpperCase(value.charAt(0));
    }
}