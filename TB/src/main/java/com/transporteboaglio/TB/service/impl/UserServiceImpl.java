package com.transporteboaglio.TB.service.impl;

import com.transporteboaglio.TB.entity.User;
import com.transporteboaglio.TB.repository.UserRepository;
import com.transporteboaglio.TB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
  return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
      return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
