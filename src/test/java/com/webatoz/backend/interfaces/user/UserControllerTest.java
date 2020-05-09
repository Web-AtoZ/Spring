package com.webatoz.backend.interfaces.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  MockMvc mvc;

  // E-mail, name, password
  // 201

  @Test
  public void create() throws Exception {
    mvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\":\"joker\",\"email\":\"isb9082@naver.com\", \"password\":\"1234\"}"))
        .andExpect(status().isCreated())
        .andExpect(header().string("location","/users/1004"));
  }
}