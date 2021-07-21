package com.pm.pm.repository;

import com.pm.pm.models.Task;

import org.springframework.data.repository.CrudRepository;

public interface taskRepository extends CrudRepository<Task, String> {
    
}
