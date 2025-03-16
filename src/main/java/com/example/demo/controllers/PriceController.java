package com.example.demo.controllers;

import com.example.demo.dto.PriceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @PostMapping("/price")
    public ResponseEntity<PriceRequest> processPrice(@RequestBody PriceRequest priceRequest) {
        if (priceRequest.getInfo() != null) {
            priceRequest.getInfo().setId(123);
        }
        return ResponseEntity.ok(priceRequest);
    }
}