package com.webatoz.backend.services.user;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.database.webatoz.user.UserRepository;
import com.webatoz.backend.interfaces.user.UserExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String name, String secret) {
        Optional<User> existed = userRepository.findByEmail(email);

        if(existed.isPresent()) {
            throw new UserExistedException(email);
        }

        PasswordEncoder secretEncoder = new BCryptPasswordEncoder();
        String encodedSecret = secretEncoder.encode(secret);

        User user = User.builder()
                .email(email)
                .name(name)
                .secret(encodedSecret)
                .build();

        return userRepository.save(user);
    }
}
