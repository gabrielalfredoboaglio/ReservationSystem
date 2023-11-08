package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.request.CreateUserDTO;
import com.transporteboaglio.TB.entity.RoleEntity;
import com.transporteboaglio.TB.entity.UserEntity;
import com.transporteboaglio.TB.enumeration.ERole;
import com.transporteboaglio.TB.repository.UserRepository;
import com.transporteboaglio.TB.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('admin_client_role')")
    public List<UserEntity> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('admin_client_role')")
    public UserEntity getUserById(@PathVariable Long id) { // Agregado @PathVariable para obtener el ID desde la URL
        return userService.getUserById(id);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@RequestParam String id) {
        userService.deleteUser(Long.parseLong(id));
        return "User deleted".concat(id);
    };
}


