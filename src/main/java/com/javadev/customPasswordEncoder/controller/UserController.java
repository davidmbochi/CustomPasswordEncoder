package com.javadev.customPasswordEncoder.controller;

import com.javadev.customPasswordEncoder.model.User;
import com.javadev.customPasswordEncoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable("id") int id){
        return userService.findUserById(id);
    }
}
