package br.edu.infnet.service;

import br.edu.infnet.model.Post;
import br.edu.infnet.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Mono<Post> save(Post post) {
        return postRepository.save(post)
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1))); // retry simples
    }

    public Flux<Post> findAll() {
        return postRepository.findAll();
    }

    public Mono<Post> findById(Long id) {
        return postRepository.findById(id);
    }
}