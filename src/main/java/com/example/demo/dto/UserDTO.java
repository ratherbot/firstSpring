package com.example.demo.dto;

import com.example.demo.annotation.ValidUserName;
import com.example.demo.validator.CaseMode;
import com.example.demo.validator.CheckCase;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @ValidUserName
    private String username;

    @NotNull(message = "Пароль не должен быть null")
    @CheckCase(value = CaseMode.UPPER, message = "Пароль должен быть в верхнем регистре")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}