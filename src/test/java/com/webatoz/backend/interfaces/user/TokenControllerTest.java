package com.webatoz.backend.interfaces.user;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.services.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import com.webatoz.backend.utils.JwtUtil;
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
//  @MockBean
//  private JwtUtil jwtUtil;
//
  @MockBean
  private UserService userService;
//
//  //given(jwtUtil.createToken(id,name)).willReturn("header.payload.signature");
    @Test
    public void createWithvaildAttributes() throws Exception {
        String email = "tester@example.com";
        String password = "test";

        User mockUser = User.builder().secret("ACCESSTOKEN").build();

        given(userService.authenticate(email,password)).willReturn(mockUser);
        mvc.perform(post("/token")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"email\":\"tester@example.com\",\"password\":\"test\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location","/token"))
                .andExpect(content().string("{\"access_token\":\"ACCESSTOKEN\"}"));

        verify(userService).authenticate(eq(email), eq(password));
    }

    @Test
    public void createWithInvaildAttributes() throws Exception {
        given(userService.authenticate("tester@example.com","x"))
                .willThrow(PasswordWrongException.class);

        mvc.perform(post("/token")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@example.com\",\"password\":\"x\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).authenticate(eq("tester@example.com"), eq("x"));
    }

    @Test
    public void createWithWrongPassword() throws Exception {
        given(userService.authenticate("tester@example.com","x"))
                .willThrow(PasswordWrongException.class);

        mvc.perform(post("/token")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@example.com\",\"password\":\"test\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).authenticate(eq("tester@example.com"), eq("x"));
    }
    @Test
    public void createWithNotExistedEmail() throws Exception {
        given(userService.authenticate("x@example.com","test"))
                .willThrow(EmailNotExistedException.class);

        mvc.perform(post("/token")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"x@example.com\",\"password\":\"test\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).authenticate(eq("x@example.com"), eq("test"));
    }

    @Test
    public void accessTokenWithPassword() {
        User user = User.builder().secret("ACCESSTOKEN").build();

        assertThat(user.getAccessToken(), is("ACCESSTOKEN"));
    }

    @Test
    public void accessTokenWithoutPassword() {
        User user = new User();

        assertThat(user.getAccessToken(), is(""));
    }

}