package com.pm.pm.controllers;

import com.pm.pm.exception.ResourceNotFoundException;
import com.pm.pm.models.User;
import com.pm.pm.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/getAlUsers")
    public Iterable<User> getAlUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUsersByID/{id}")
    public User getUsersByID(@Validated @PathVariable String id) throws ResourceNotFoundException {
        User user = userService.getUserByID(id);
        if (user == null)
            throw new ResourceNotFoundException("User not found for this id :: " + id);
        return user;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        try {
            user = userService.addUser(user);
        }
        catch(Exception e){
            throw new ResourceNotFoundException("Error");
        }
        return user;
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws ResourceNotFoundException {
        String userID = user.getUserID();
        System.out.println(userID);
        try {
            userService.getUserByID(userID);
        } catch (Exception e) {
            throw new ResourceNotFoundException(user + " not found");
        }

        user = userService.updateUser(user);
        System.out.println(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable String id) throws ResourceNotFoundException {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found for this id :: " + id);
        }
    }
}
