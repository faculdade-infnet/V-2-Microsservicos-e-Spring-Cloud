package com.infnet.tp1serviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Tp1ServiceBApplication {
    public static void main(String[] args) {
        SpringApplication.run(Tp1ServiceBApplication.class, args);
    }
}
