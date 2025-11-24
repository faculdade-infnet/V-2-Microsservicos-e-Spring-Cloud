package br.edu.infnet.controller;

import br.edu.infnet.model.Post;
import br.edu.infnet.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @Operation(summary = "Criar Post", tags = "Posts")
    @PostMapping
    public Mono<Post> createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @Operation(summary = "Obter todos os Post", tags = "Posts")
    @GetMapping
    public Flux<Post> getAllPosts() {
        return postService.findAll();
    }

    @Operation(summary = "Obter Informações de um Post existente", tags = "Posts")
    @GetMapping("/{id}")
    public Mono<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

}