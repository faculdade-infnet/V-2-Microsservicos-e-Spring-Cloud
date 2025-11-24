package br.edu.infnet;

import org.springframework.boot.SpringApplication;

public class TestTP3Application {

    public static void main(String[] args) {
        SpringApplication.from(TP3Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
