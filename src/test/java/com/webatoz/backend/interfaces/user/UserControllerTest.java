package com.webatoz.backend.interfaces.user;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.services.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

  @Autowired
  MockMvc mvc;
  private UserService userService;

  @Test
  public void create() throws Exception {

    User mockUser = User.builder()
            .userId(1004)
            .email("tester@example.com")
            .name("Tester")
            .secret("test")
            .build();

    given(userService.registerUser("tester@example.com", "Tester", "test"))
      .willReturn(mockUser);

    mvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"email\":\"tester@example.com\",\"name\":\"Tester\",\"password\":\"test\"}"))
        .andExpect(status().isCreated())
        .andExpect(header().string("location","/users/1004"));

    verify(userService).registerUser(eq("tester@example.com"), eq("Tester"), eq("test"));
  }
}