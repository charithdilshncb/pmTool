package com.pm.pm.services;

import java.util.ArrayList;
import java.util.List;

import com.pm.pm.models.Task;
import com.pm.pm.repository.taskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    taskRepository taskRepository;

    List<Task> taskList = null;

    public TaskService(){
        taskList =  new ArrayList<Task>();
    }
    
    public Iterable<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskByID(String id){
        return taskRepository.findById(id).get();
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(String id){
        taskRepository.deleteById(id);
    }
}
