package com.example.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/support")
public class SupportController {

    @RolesAllowed("SUPPORT")
    @GetMapping("/api")
    public Map<String, Object> supportApi(Principal principal) {
        Authentication auth = (Authentication) principal;
        return Map.of(
                "user", auth.getName(),
                "roles", auth.getAuthorities()
                        .stream()
                        .map(Object::toString)
                        .toList()
        );
    }
}