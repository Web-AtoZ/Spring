package com.webatoz.backend.services.user;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.database.webatoz.user.UserRepository;
import com.webatoz.backend.interfaces.user.EmailNotExistedException;
import com.webatoz.backend.interfaces.user.PasswordWrongException;
import com.webatoz.backend.interfaces.user.UserExistedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder secretEncoder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, secretEncoder);
    }

    @Test
    public void registerUser() {
        String email = "tester@example.com";
        String name = "Tester";
        String secret = "test";

        userService.registerUser(email, name, secret);

        verify(userRepository).save(any());
    }

    @Test(expected = UserExistedException.class)
    public void registerUserWithExistedEmail() {
        String email = "tester@example.com";
        String name = "Tester";
        String secret = "test";

        User user = User.builder()
                .build();

        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));

        userService.registerUser(email, name, secret);

        verify(userRepository, never()).save(any());
    }

    @Test
    public void authenticateWithVaildAttribute() {
        String email = "tester@example.com";
        String secret = "test";

        User mockUser = User.builder().email(email).build();

        given(userRepository.findByEmail(email))
                .willReturn(Optional.of(mockUser));

        given(secretEncoder.matches(any(),any())).willReturn(true);

        User user = userService.authenticate(email, secret);

        assertThat(user.getEmail(), is(email));
    }

    @Test(expected = EmailNotExistedException.class)
    public void authenticateWithNotExistedEmail() {
        String email = "x@example.com";
        String secret = "test";

        User mockUser = User.builder().email(email).build();

        given(userRepository.findByEmail(email))
                .willReturn(Optional.empty());

        userService.authenticate(email, secret);
    }

    @Test(expected = PasswordWrongException.class)
    public void authenticateWithWrongPassword() {
        String email = "tester@example.com";
        String secret = "x";

        User mockUser = User.builder().email(email).build();

        given(userRepository.findByEmail(email))
                .willReturn(Optional.of(mockUser));

        given(secretEncoder.matches(any(),any())).willReturn(false);

        userService.authenticate(email, secret);
    }
}