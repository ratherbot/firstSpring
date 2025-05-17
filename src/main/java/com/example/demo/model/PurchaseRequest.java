package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PurchaseRequest(
        @NotBlank String product,
        @Min(1) int quantity
) {}