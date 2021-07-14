package com.pm.pm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pm.pm.models.User;
import com.pm.pm.repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    userRepository userRepository;

    List<User> userList = null;

    public UserService(){
        userList =  new ArrayList<User>();
    }
    
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserByID(String id){
        return userRepository.findById(id);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
