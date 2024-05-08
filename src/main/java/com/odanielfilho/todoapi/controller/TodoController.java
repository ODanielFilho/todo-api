package com.odanielfilho.todoapi.controller;

import com.odanielfilho.todoapi.entity.Todo;
import com.odanielfilho.todoapi.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping
    List<Todo> createTodo(@RequestBody @Valid Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping
    List<Todo> getAllTodos() {
        return todoService.getTodos();
    }

    @PutMapping
    List<Todo> updateTodo(@RequestBody @Valid Todo todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }

}
