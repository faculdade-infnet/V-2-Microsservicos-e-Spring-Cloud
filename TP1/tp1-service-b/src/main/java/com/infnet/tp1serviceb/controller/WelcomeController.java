package com.infnet.tp1serviceb.controller;

import com.infnet.tp1serviceb.service.ServiceAClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private final ServiceAClient serviceAClient;

    public WelcomeController(ServiceAClient serviceAClient) {
        this.serviceAClient = serviceAClient;
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        String baseMessage = serviceAClient.getGreeting();
        return baseMessage + " " + name + "!";
    }
}
