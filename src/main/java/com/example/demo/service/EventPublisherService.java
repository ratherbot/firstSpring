package com.example.demo.service;

import com.example.demo.event.CustomEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EventPublisherService {
    private static final Logger log = LoggerFactory.getLogger(EventPublisherService.class);
    private final ApplicationEventPublisher publisher;

    public EventPublisherService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishStandardEvent() {
        log.info("[{}] Publishing standard event", LocalDateTime.now());
        publisher.publishEvent(new CustomEvent("StandardEvent"));
    }

    public void publishAsyncEvent() {
        log.info("[{}] Publishing async event", LocalDateTime.now());
        publisher.publishEvent(new CustomEvent("AsyncEvent"));
    }

    @Transactional
    public void publishTransactionalEventSuccess() {
        log.info("[{}] Publishing transactional event (will commit)", LocalDateTime.now());
        publisher.publishEvent(new CustomEvent("TransactionalSuccess"));
    }

    @Transactional
    public void publishTransactionalEventFailure() {
        log.info("[{}] Publishing transactional event (will rollback)", LocalDateTime.now());
        publisher.publishEvent(new CustomEvent("TransactionalFailure"));
        log.info("[{}] Throwing exception to rollback transaction", LocalDateTime.now());
        throw new RuntimeException("Simulated failure");
    }
}