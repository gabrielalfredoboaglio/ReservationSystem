package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.entity.User;

import com.transporteboaglio.TB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("/list")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping ("/{id}")
    public User getUserById(Long id){
        return userService.getUserById(id);
    }

    @PostMapping ("/save")
    public User saveUser(User user){
        return userService.saveUser(user);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteUser(Long id){
        userService.deleteUser(id);
    }
}
