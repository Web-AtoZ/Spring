package com.webatoz.backend.interfaces.user;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.services.user.UserService;
import com.webatoz.backend.utils.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
@RunWith(SpringRunner.class)
@WebMvcTest(TokenController.class)
public class TokenControllerTest {
  @Autowired
  MockMvc mvc;
//
  @MockBean
  private JwtUtil jwtUtil;

  @MockBean
  private UserService userService;
//

    @Test
    public void createWithvaildAttributes() throws Exception {
        String email = "tester@example.com";
        Integer id = 1004;
        String name = "John";
        String secret = "test";

        User mockUser = User.builder().userId(id).name(name).build();

        given(userService.authenticate(email,secret)).willReturn(mockUser);

        given(jwtUtil.createToken(id,name)).willReturn("header.payload.signature");

        mvc.perform(post("/token")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"email\":\"tester@example.com\",\"secret\":\"test\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location","/token"))
                .andExpect(content().string(containsString("header.payload.signature")));

        verify(userService).authenticate(eq(email), eq(secret));
    }

    @Test
    public void createWithInvaildAttributes() throws Exception {
        given(userService.authenticate("tester@example.com","x"))
                .willThrow(PasswordWrongException.class);

        mvc.perform(post("/token")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@example.com\",\"secret\":\"x\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).authenticate(eq("tester@example.com"), eq("x"));
    }

    @Test
    public void createWithWrongPassword() throws Exception {
        given(userService.authenticate("tester@example.com","x"))
                .willThrow(PasswordWrongException.class);

        mvc.perform(post("/token")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@example.com\",\"secret\":\"test\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).authenticate(eq("tester@example.com"), eq("x"));
    }
    @Test
    public void createWithNotExistedEmail() throws Exception {
        given(userService.authenticate("x@example.com","test"))
                .willThrow(EmailNotExistedException.class);

        mvc.perform(post("/token")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"x@example.com\",\"secret\":\"test\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).authenticate(eq("x@example.com"), eq("test"));
    }


}