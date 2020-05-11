package com.webatoz.backend.interfaces.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.webatoz.backend.application.user.UserService;
import com.webatoz.backend.database.webatoz.user.User;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  MockMvc mvc;

  @MockBean
  private UserService userService;

  // E-mail, name, password
  // 201

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
        .content("{\"name\":\"Tester\",\"email\":\"tester@example.com\", \"password\":\"test\"}"))
        .andExpect(status().isCreated())
        .andExpect(header().string("location","/users/1004"));

    verify(userService).registerUser(
        eq("tester@example.com"), eq("Tester"), eq("Test"));
  }

//    @Test
//    public void create() throws Exception {
//        mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(header().string("location", "/users/2"))
//                .andExpect(content().string("{}"));
//    }
}