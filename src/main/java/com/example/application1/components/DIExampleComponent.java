package com.example.application1.components;

import com.example.application1.services.GreetingService;
import com.example.application1.services.AnotherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DIExampleComponent {

    // DI через конструктор
    private final GreetingService constructorInjectedGreetingService;

    // DI через поле
    @Autowired
    @Qualifier("russianGreetingService")
    private GreetingService fieldInjectedGreetingService;

    private AnotherService setterInjectedAnotherService;

    // Конструкторная инъекция с использованием Qualifier
    @Autowired
    public DIExampleComponent(@Qualifier("englishGreetingService") GreetingService constructorInjectedGreetingService) {
        this.constructorInjectedGreetingService = constructorInjectedGreetingService;
    }

    // Сеттерная инъекция
    @Autowired
    public void setSetterInjectedAnotherService(AnotherService setterInjectedAnotherService) {
        this.setterInjectedAnotherService = setterInjectedAnotherService;
    }

    public void demonstrateInjection() {
        System.out.println("Constructor Injection: " + constructorInjectedGreetingService.greet());
        System.out.println("Field Injection: " + fieldInjectedGreetingService.greet());
        setterInjectedAnotherService.doSomething();
    }
}