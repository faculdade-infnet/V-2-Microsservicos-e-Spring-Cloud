package com.infnet.Cloud.demo.controller;

import com.infnet.Cloud.demo.service.HelloRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World";
    }

    @GetMapping("/{firstname}")
    public String helloGet(@PathVariable String firstName, @RequestParam String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody HelloRequest request) {
        return String.format("{\"message\":\"Hello %s %s\"}", request.getFirstName(), request.getLastName());
    }
}
