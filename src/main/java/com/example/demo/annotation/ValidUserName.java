package com.example.demo.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
@NotNull
@Size(min = 3, max = 50)
@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Имя пользователя должно состоять только из букв и цифр")
public @interface ValidUserName {
    String message() default "Некорректное имя пользователя";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}