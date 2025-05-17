package com.example.demo.controller;

import com.example.demo.model.PurchaseRequest;
import com.example.demo.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> purchase(@Validated @RequestBody PurchaseRequest req) {
        service.recordPurchase(req.product(), req.quantity());
        return ResponseEntity.ok("Purchased " + req.quantity() + " of " + req.product());
    }
}