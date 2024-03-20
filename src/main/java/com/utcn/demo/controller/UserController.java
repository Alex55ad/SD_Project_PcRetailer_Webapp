package com.utcn.demo.controller;

import com.utcn.demo.entity.User;
import com.utcn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getAllUsers")
    public List<User> retrieveAllUsers(){
        return userService.retrieveUsers();
    }

    @PostMapping("/insertUser")
    public User insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @DeleteMapping("/deleteUserById")
    public void deleteUserById(@RequestParam Long id){
        userService.deleteUserById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password){
        User user = userService.loginUser(username, password);
        if (user != null){
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.badRequest().body("Username or Password invalid");
        }
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
