package br.edu.infnet;

import org.springframework.boot.SpringApplication;

public class TestProgramacaoReativaApplication {

    public static void main(String[] args) {
        SpringApplication.from(ProgramacaoReativaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
