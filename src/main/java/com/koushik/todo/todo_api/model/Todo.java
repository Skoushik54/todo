package com.koushik.todo.todo_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    private String title;

    @Column(length = 500)
    private String description;

    private boolean completed = false;

    // 🧩 Category of the task (Work, Personal, etc.)
    private String category;

    // 🧩 Task priority (LOW, MEDIUM, HIGH)
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;

    // 🧩 Optional due date
    private LocalDateTime dueDate;

    // 🕒 Automatically handled timestamps
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
