package com.koushik.todo.todo_api.service;

import com.koushik.todo.todo_api.model.Todo;
import com.koushik.todo.todo_api.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Page<Todo> getAllTodos(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    public Todo getTodoById(UUID id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(UUID id, Todo updatedTodo) {
        Todo existing = getTodoById(id);
        existing.setTitle(updatedTodo.getTitle());
        existing.setDescription(updatedTodo.getDescription());
        existing.setCompleted(updatedTodo.isCompleted());
        existing.setCategory(updatedTodo.getCategory());
        existing.setPriority(updatedTodo.getPriority());
        existing.setDueDate(updatedTodo.getDueDate());
        return todoRepository.save(existing);
    }

    public void deleteTodo(UUID id) {
        todoRepository.deleteById(id);
    }
}
