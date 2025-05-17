package com.example.demo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Endpoint(id = "customLog")
public class CustomLogEndpoint {
    private static final Logger log = LoggerFactory.getLogger(CustomLogEndpoint.class);

    @ReadOperation
    public String logNow() {
        String msg = "Endpoint 'customLog' was called at " + LocalDateTime.now();
        log.info(msg);
        return msg;
    }
}