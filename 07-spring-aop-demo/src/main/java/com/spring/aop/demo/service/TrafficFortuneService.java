package com.spring.aop.demo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Heavy traffic";
    }

    public String getFortune(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Highway is closed!");
        }

        return getFortune();
    }
}
