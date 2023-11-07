package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.request.CreateUserDto;
import com.transporteboaglio.TB.entity.RoleEntity;
import com.transporteboaglio.TB.entity.UserEntity;
import com.transporteboaglio.TB.enumeration.Erole;
import com.transporteboaglio.TB.repository.UserRepository;
import com.transporteboaglio.TB.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users") // Cambiado a "users" para que la URL sea más coherente
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public List<UserEntity> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) { // Agregado @PathVariable para obtener el ID desde la URL
        return userService.getUserById(id);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto createUserDto) {

        Set<RoleEntity> roles = createUserDto.getRoles().stream().map(role -> RoleEntity.builder().name(Erole.valueOf(role)).build()).collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder().
                username(createUserDto.getUsername()).
                password(passwordEncoder.encode(createUserDto.getPassword())).
                email(createUserDto.getEmail()).
                roles(roles).build();
        userService.createUser ( userEntity);

        return ResponseEntity.ok(userEntity);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@RequestParam String id) {
        userService.deleteUser(Long.parseLong(id));
        return "User deleted".concat(id);
    };
}


