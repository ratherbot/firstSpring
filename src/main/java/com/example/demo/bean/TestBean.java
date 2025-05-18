package com.example.demo.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestBean {
    public TestBean() {
        System.out.println("TestBean инициализирован, так как активен профиль 'test'");
    }
}