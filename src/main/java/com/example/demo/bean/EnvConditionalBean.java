package com.example.demo.bean;

import com.example.demo.config.ExampleTestNotDefaultCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(ExampleTestNotDefaultCondition.class)
public class EnvConditionalBean {
    public EnvConditionalBean() {
        System.out.println("EnvConditionalBean создан, так как EXAMPLE_TEST != 'default'");
    }
}