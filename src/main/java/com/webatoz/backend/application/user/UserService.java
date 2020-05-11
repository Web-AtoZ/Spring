package com.webatoz.backend.application.user;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.database.webatoz.user.UserRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

  UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User registerUser(String email, String name, String secret) {
    Optional<User> userRepository.findByEmail(email);

    if(existed.isPresent()) {
      throw new EmailExistedException(email);
    }

    PasswordEncoder secretEncoder = new BCryptPasswordEncoder();
    String encodedSecret = secretEncoder.encode(secret);

    User user = User.builder()
        .userId(1004)
        .email(email)
        .name(name)
        .secret(encodedSecret)
        .build();

    return userRepository.save(user);
  }
}
