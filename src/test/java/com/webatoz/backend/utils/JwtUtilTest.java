package com.webatoz.backend.utils;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

//
//import static org.hamcrest.Matchers.containsString;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.Test;
//
public class JwtUtilTest {

  @Test
  public void createToken() {
    String secret = "123456789012";

    JwtUtil jwtUtil = new JwtUtil(secret);

    String token = jwtUtil.createToken(1004, "john");

    assertThat(token, containsString("."));
  }
}