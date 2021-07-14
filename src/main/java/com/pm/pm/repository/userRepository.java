package com.pm.pm.repository;

import com.pm.pm.models.User;

import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, String> {
    
}
