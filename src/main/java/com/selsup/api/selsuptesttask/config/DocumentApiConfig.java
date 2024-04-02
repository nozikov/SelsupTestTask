package com.selsup.api.selsuptesttask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Configuration
public class DocumentApiConfig {

    @Value("${document.api.requestLimit}")
    private int requestLimit;

    @Value("${document.api.timeUnit}")
    private TimeUnit timeUnit;

    @Bean
    public Semaphore semaphore() {
        return new Semaphore(requestLimit);
    }

    @Bean
    public long requestInterval() {
        return timeUnit.toMillis(1);
    }
}
