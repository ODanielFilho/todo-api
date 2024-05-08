package com.odanielfilho.todoapi.repository;

import com.odanielfilho.todoapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {
}
