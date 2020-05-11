package com.webatoz.backend.application.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.database.webatoz.user.UserRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class UserServiceTest {

  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    userService = new UserService(userRepository);
  }

  @Test
  public void registerUser() {
    String email = "test@example.com";
    String name = "Tester";
    String secret = "test";

    userService.registerUser(email, name, secret);

    verify(userRepository).save(any());
  }

  @Test(expected= EmailExistedException.class)
  public void registerUserWithExistedEmail() {
    String email = "test@example.com";
    String name = "Tester";
    String secret = "test";


    User mockUser = User.builder().build();
    given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));

    userService.registerUser(email, name, secret);

    verify(userRepository, never()).save(any());
  }
}