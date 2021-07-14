package com.pm.pm.controllers;

import com.pm.pm.exception.ResourceNotFoundException;
import com.pm.pm.models.User;
import com.pm.pm.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/getAlUsers")
    public Iterable<User> getAlUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUsersByID/{id}")
    public ResponseEntity<User> getUsersByID(@PathVariable String id) throws ResourceNotFoundException {
        User user = userService.getUserByID(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    // @PutMapping("/updateUser")
    // public User updateUser(@RequestBody User user){
    //     return userService.updateUser(user);
    // }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    throws ResourceNotFoundException {
        User user2 =  userService.updateUser(user)
        .orElseThrow(() -> new ResourceNotFoundException( user +" not found"));
        return ResponseEntity.ok().body(user2);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

}
