package com.example.demo.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(TestBean.class)
public class DependentBean {
    public DependentBean() {
        System.out.println("DependentBean создан, так как TestBean существует");
    }
}