package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Task addTask(String description, LocalDateTime targetCompletionTime) {
        Task task = new Task(counter.incrementAndGet(), description, targetCompletionTime);
        tasks.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void toggleTask(Long id) {
        tasks.stream()
            .filter(task -> task.getId().equals(id))
            .findFirst()
            .ifPresent(task -> task.setCompleted(!task.isCompleted()));
    }

    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}