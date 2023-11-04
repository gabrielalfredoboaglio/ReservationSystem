package com.transporteboaglio.TB.repository;


import com.transporteboaglio.TB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
