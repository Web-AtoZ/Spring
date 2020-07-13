package com.webatoz.backend.services.user;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.database.webatoz.user.UserRepository;
import com.webatoz.backend.interfaces.user.EmailNotExistedException;
import com.webatoz.backend.interfaces.user.PasswordWrongException;
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

    PasswordEncoder secretEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder secretEncoder) {
        this.userRepository = userRepository;
        this.secretEncoder = secretEncoder;
    }

    public User registerUser(User resource) {
        String account = resource.getAccount();
        String email = resource.getEmail();
        String secret = resource.getSecret();
        String name = resource.getName();
        Optional<User> existed = userRepository.findByAccount(account);

        if(existed.isPresent()) {
            throw new UserExistedException(account);
        }

        String encodedSecret = secretEncoder.encode(secret);

        User user = User.builder()
                .account(account)
                .email(email)
                .name(name)
                .secret(encodedSecret)
                .build();

        return userRepository.save(user);
    }

    public User authenticate(String account, String secret) {
        User user = userRepository.findByEmail(account)
                .orElseThrow(() -> new EmailNotExistedException(account));

        if(!secretEncoder.matches(secret, user.getSecret())){
            throw new PasswordWrongException();
        }

        return user;
    }

}
