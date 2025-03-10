package com.example.application1.services;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("russianGreetingService")
public class RussianGreetingService implements GreetingService {

    @PostConstruct
    public void init() {
        System.out.println("RussianGreetingService bean created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("RussianGreetingService bean destroyed");
    }

    @Override
    public String greet() {
        return "Привет!";
    }
}