package com.transporteboaglio.TB.controller;

import com.transporteboaglio.TB.request.CreateUserDTO;
import com.transporteboaglio.TB.entity.RoleEntity;
import com.transporteboaglio.TB.entity.UserEntity;
import com.transporteboaglio.TB.enumeration.ERole;
import com.transporteboaglio.TB.repository.UserRepository;
import com.transporteboaglio.TB.service.RecaptchaService;
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
    private RecaptchaService recaptchaService;

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
    public ResponseEntity<?> createUser(@ModelAttribute(name= "user") @Valid @RequestBody CreateUserDTO createUserDTO, @RequestParam( name="g-recaptcha-response") String captcha) {


        boolean captchaValid = recaptchaService.validateRecaptcha(captcha);

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        if(captchaValid) {
            UserEntity userEntity = UserEntity.builder()
                    .username(createUserDTO.getUsername())
                    .password(passwordEncoder.encode(createUserDTO.getPassword()))
                    .email(createUserDTO.getEmail())
                    .roles(roles)
                    .build();

            userService.createUser(userEntity);
            return ResponseEntity.ok(userEntity);
        }
        else {
            return ResponseEntity.badRequest().body("Captcha invalid");
        }
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@RequestParam String id) {
        userService.deleteUser(Long.parseLong(id));
        return "User deleted".concat(id);
    };
}


