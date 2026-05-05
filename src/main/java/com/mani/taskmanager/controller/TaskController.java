package com.mani.taskmanager.controller;

import com.mani.taskmanager.model.Task;
import com.mani.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository repo;

    // Show all tasks
    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("tasks", repo.findAll());
        model.addAttribute("task", new Task());
        return "index";
    }

    // Add task
    @PostMapping("/add")
    public String addTask(Task task) {
        repo.save(task);
        return "redirect:/";
    }

    // Delete task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
