package com.example.application1.services;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("englishGreetingService") // задаём имя бина для использования Qualifier
public class EnglishGreetingService implements GreetingService {

    @PostConstruct
    public void init() {
        System.out.println("EnglishGreetingService bean created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EnglishGreetingService bean destroyed");
    }

    @Override
    public String greet() {
        return "Hello!";
    }
}