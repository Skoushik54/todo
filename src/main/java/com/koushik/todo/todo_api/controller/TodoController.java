package com.koushik.todo.todo_api.controller;

import com.koushik.todo.todo_api.model.Todo;
import com.koushik.todo.todo_api.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public Page<Todo> getAllTodos(Pageable pageable) {
        return todoService.getAllTodos(pageable);
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable UUID id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable UUID id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable UUID id) {
        todoService.deleteTodo(id);
    }
}
