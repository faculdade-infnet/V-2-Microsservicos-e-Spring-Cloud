package br.edu.infnet.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserClient {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8081/users")
            .build();

    public Mono<String> getUserById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }
}
