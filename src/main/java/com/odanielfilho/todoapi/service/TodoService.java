package com.odanielfilho.todoapi.service;

import com.odanielfilho.todoapi.entity.Todo;
import com.odanielfilho.todoapi.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<Todo> createTodo(Todo todo) {
        todoRepository.save(todo);
        return getTodos();
    }

    public List<Todo> getTodos() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<Todo> updateTodo(Todo todo) {
        todoRepository.save(todo);
        return getTodos();
    }

    public List<Todo> deleteTodo(Long id) {
        todoRepository.deleteById(id);
        return getTodos();
    }
}
