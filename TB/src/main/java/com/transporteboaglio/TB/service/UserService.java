package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> listUsers();
    UserEntity getUserById(Long id);
    UserEntity createUser(UserEntity user);
    void deleteUser(Long id);
}


