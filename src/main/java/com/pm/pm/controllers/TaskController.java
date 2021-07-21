package com.pm.pm.controllers;

import com.pm.pm.exception.ResourceNotFoundException;
import com.pm.pm.models.Task;
import com.pm.pm.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/task")
    public String task(){
        return "task";
    }

    @GetMapping("/getAllTasks")
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTaskByID/{id}")
    public Task getTaskByID(@PathVariable String id) throws ResourceNotFoundException {
        Task task = taskService.getTaskByID(id);
        if (task == null)
            throw new ResourceNotFoundException("Task not found for this id :: " + id);
        return task;
    }

    @PostMapping("/addTask")
    public Task addUser(@RequestBody Task task) {
        try{
            System.out.println(task);
           task =  taskService.addTask(task);
        }
        catch(Exception e){
            throw new ResourceNotFoundException("Error!");
        }
        return task;
    }
    
    @PutMapping("/updateTask")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) throws ResourceNotFoundException {
        Task task2 = taskService.updateTask(task);
        if (task2 == null)
            throw new ResourceNotFoundException(task + " not found");
        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable String id) throws ResourceNotFoundException {
        try {
            taskService.deleteTask(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Task not found for this id :: " + id);
        }
    }

}
