package com.webatoz.backend.database.webatoz.user;


import java.util.Optional;
import org.openjdk.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  List<User> findAll();

  Optional<User> findById(String id);

  Optional<User> findByEmail(String email);
}
