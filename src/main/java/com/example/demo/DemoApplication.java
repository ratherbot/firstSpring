package com.example.demo;

import com.example.demo.service.EventPublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
public class DemoApplication implements CommandLineRunner {

    private final EventPublisherService publisherService;

    public DemoApplication(EventPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        publisherService.publishStandardEvent();

        publisherService.publishAsyncEvent();

        publisherService.publishTransactionalEventSuccess();

        try {
            publisherService.publishTransactionalEventFailure();
        } catch (RuntimeException ex) {
        }

        TimeUnit.SECONDS.sleep(2);
    }
}