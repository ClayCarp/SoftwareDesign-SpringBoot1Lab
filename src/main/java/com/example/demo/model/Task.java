package com.example.demo.model;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String description;
    private boolean completed;
    private LocalDateTime targetCompletionTime;

    public Task() {}

    public Task(Long id, String description, LocalDateTime targetCompletionTime) {
        this.id = id;
        this.description = description;
        this.targetCompletionTime = targetCompletionTime;
        this.completed = false;
    }

    public LocalDateTime getTargetCompletionTime() {
        return targetCompletionTime;
    }

    public void setTargetCompletionTime(LocalDateTime targetCompletionTime) {
        this.targetCompletionTime = targetCompletionTime;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}