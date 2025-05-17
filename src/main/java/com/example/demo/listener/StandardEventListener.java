package com.example.demo.listener;

import com.example.demo.event.CustomEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StandardEventListener {
    private static final Logger log = LoggerFactory.getLogger(StandardEventListener.class);

    @EventListener
    public void handleStandard(CustomEvent event) {
        log.info("[{}] StandardEventListener handled: {}", LocalDateTime.now(), event.message());
    }
}