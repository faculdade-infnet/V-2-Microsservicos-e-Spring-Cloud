package com.infnet.Cloud.demo.controller;

import com.infnet.Cloud.demo.model.Hello;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello, World";
//    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello, " + name;
    }

    @GetMapping("/{firstname}")
    public String helloGet(@PathVariable String firstname, @RequestParam String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstname, lastName);
    }


    @PostMapping("/hello")
    public String helloPost(@RequestBody Hello request) {
        return String.format("{\"message\":\"Hello %s %s\"}", request.getFirstName(), request.getLastName());
    }
}
