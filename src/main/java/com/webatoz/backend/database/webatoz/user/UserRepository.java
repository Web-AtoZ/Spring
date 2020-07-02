package com.webatoz.backend.database.webatoz.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByAccount(String account);
    Optional<User> findByEmail(String email);
}
