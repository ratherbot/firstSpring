package com.example.demo.listener;

import com.example.demo.event.CustomEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@Component
public class MyTransactionalEventListener {
    private static final Logger log = LoggerFactory.getLogger(TransactionalEventListener.class);

    @TransactionalEventListener
    public void handleTransactional(CustomEvent event) {
        log.info("[{}] TransactionalEventListener handled: {}", LocalDateTime.now(), event.message());
    }
}