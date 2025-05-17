package com.example.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PurchaseService {
    private final MeterRegistry registry;
    private final Counter requestCounter;
    private final Timer requestTimer;
    private final Map<String, Counter> productCounters = new ConcurrentHashMap<>();

    public PurchaseService(MeterRegistry registry) {
        this.registry = registry;
        this.requestCounter = registry.counter("requests.total");
        this.requestTimer = registry.timer("requests.latency");
    }

    public void recordPurchase(String product, int quantity) {
        requestCounter.increment();

        requestTimer.record(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {}
        });

        Counter pc = productCounters.computeIfAbsent(product, p ->
                Counter.builder("purchases.by.product")
                        .tag("product", p)
                        .register(registry)
        );
        pc.increment(quantity);
    }
}