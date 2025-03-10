package com.example.application1;

import com.example.application1.components.DIExampleComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application1Application {
    public static void main(String[] args) {
        SpringApplication.run(Application1Application.class, args);
    }

    // Запускаем демонстрацию DI после инициализации контекста
    @Bean
    public CommandLineRunner runner(DIExampleComponent diExampleComponent) {
        return args -> {
            diExampleComponent.demonstrateInjection();
        };
    }
}