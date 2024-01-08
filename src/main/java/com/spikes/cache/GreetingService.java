package com.spikes.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private static final String template = "Hello, %s!";

    @Cacheable(value = "greeting", key = "#name")
    public String cachedGgreeting(Integer delay, String name){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format(template, name);
    }
}