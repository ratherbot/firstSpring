package com.example.demo.listener;

import com.example.demo.event.CustomEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AsyncEventListener {
    private static final Logger log = LoggerFactory.getLogger(AsyncEventListener.class);

    @Async
    @EventListener
    public void handleAsync(CustomEvent event) {
        log.info("[{}] AsyncEventListener handled: {}", LocalDateTime.now(), event.message());
    }
}