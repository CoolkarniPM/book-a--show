package com.usermanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
