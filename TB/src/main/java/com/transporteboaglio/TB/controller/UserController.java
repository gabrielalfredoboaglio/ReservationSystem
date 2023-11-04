package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.entity.User;
import com.transporteboaglio.TB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // Cambiado a "users" para que la URL sea más coherente
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) { // Agregado @PathVariable para obtener el ID desde la URL
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) { // Agregado @RequestBody para obtener el usuario desde el cuerpo de la solicitud
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) { // Agregado @PathVariable para obtener el ID desde la URL
        userService.deleteUser(id);
    }
}

