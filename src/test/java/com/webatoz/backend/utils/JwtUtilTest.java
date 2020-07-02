package com.webatoz.backend.utils;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import io.jsonwebtoken.Claims;
import org.junit.Before;
import org.junit.Test;

//
//import static org.hamcrest.Matchers.containsString;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.Test;
//
public class JwtUtilTest {

  private static final String SECRET = "12345678901234567890123456789012";

  private JwtUtil jwtUtil;

  @Before
  public void setUp() {
    jwtUtil = new JwtUtil(SECRET);
  }

  @Test
  public void createToken() {

    String token = jwtUtil.createToken(1004, "john");

    assertThat(token, containsString("."));
  }

  @Test
  public void getClaims() {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJqb2huIn0.RvCrbP473aakKmeFxmIDfeV_2uPT54rdoqcYhsqAhII";
    Claims claims = jwtUtil.getClaims(token);

    assertThat(claims.get("userId", Integer.class), is(1004));
    assertThat(claims.get("name"), is("john"));
  }
}