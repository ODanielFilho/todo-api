package com.odanielfilho.todoapi;

import com.odanielfilho.todoapi.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoApiApplicationTests {
    @Autowired
    WebTestClient webClient;

    @Test
    void createTodoSuccess() {
        var todo = new Todo("todo 1", "desc todo 1", false, 1);
        webClient.post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$[0].priority").isEqualTo(todo.getPriority())
                .jsonPath("$[0].completed").isEqualTo(todo.isCompleted());
    }

    @Test
    void createTodoFailure() {
        var todoFail = new Todo("", "", false, 0);
        webClient.post()
                .uri("/todos")
                .bodyValue(todoFail)
                .exchange()
                .expectStatus().isBadRequest();
    }

}
