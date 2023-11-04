package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
}


