package com.example.demo.dto;

import java.util.List;

public record TodoListDTO(
        String name,
        List<String> events
) {}