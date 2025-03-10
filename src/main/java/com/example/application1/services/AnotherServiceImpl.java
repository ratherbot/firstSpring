package com.example.application1.services;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class AnotherServiceImpl implements AnotherService {

    @PostConstruct
    public void init() {
        System.out.println("AnotherServiceImpl bean created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AnotherServiceImpl bean destroyed");
    }

    @Override
    public void doSomething() {
        System.out.println("AnotherService is doing something.");
    }
}