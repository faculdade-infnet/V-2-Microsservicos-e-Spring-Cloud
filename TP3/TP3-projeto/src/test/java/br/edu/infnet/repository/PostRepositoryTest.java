package br.edu.infnet.repository;

import br.edu.infnet.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.r2dbc.test.autoconfigure.DataR2dbcTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.test.StepVerifier;

@DataR2dbcTest
@Testcontainers
public class PostRepositoryTest {

    @Container
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private PostRepository postRepository;

    // Atualiza a URL do R2DBC dinamicamente
    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        String r2dbcUrl = String.format(
                "r2dbc:postgresql://%s:%s/%s",
                postgresContainer.getHost(),
                postgresContainer.getFirstMappedPort(),
                postgresContainer.getDatabaseName()
        );
        registry.add("spring.r2dbc.url", () -> r2dbcUrl);
        registry.add("spring.r2dbc.username", postgresContainer::getUsername);
        registry.add("spring.r2dbc.password", postgresContainer::getPassword);
    }

    @Test
    void testSaveAndFind() {
        Post post = new Post();
        post.setTitulo("Hello Testcontainers");
        post.setConteudo("Conteúdo do post");

        StepVerifier.create(postRepository.save(post))
                .expectNextMatches(saved -> saved.getId() != null)
                .verifyComplete();

        StepVerifier.create(postRepository.findAll())
                .expectNextCount(1)
                .verifyComplete();
    }
}