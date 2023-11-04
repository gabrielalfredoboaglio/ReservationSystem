package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.User;
import com.transporteboaglio.TB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements com.transporteboaglio.TB.service.impl.UserService {
@Autowired
private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
