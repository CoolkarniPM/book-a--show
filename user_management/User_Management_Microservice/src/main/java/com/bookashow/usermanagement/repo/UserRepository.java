package com.bookashow.usermanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookashow.usermanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
