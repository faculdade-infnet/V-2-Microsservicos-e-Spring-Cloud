package com.infnet.tp1serviceb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-a", url = "http://localhost:8081")
public interface ServiceAClient {
    @GetMapping("/greeting")
    String getGreeting();
}
