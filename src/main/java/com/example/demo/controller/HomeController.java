package com.example.demo.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TaskService;

@Controller
public class HomeController {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }

    @PostMapping("/task")
    public String addTask(@RequestParam String description, 
                         @RequestParam String targetTime) {
        LocalDateTime targetDateTime = LocalDateTime.parse(targetTime);
        taskService.addTask(description, targetDateTime);
        return "redirect:/";
    }

    @PostMapping("/task/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @PostMapping("/task/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}