package com.koushik.todo.todo_api.repository;

import com.koushik.todo.todo_api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
}
