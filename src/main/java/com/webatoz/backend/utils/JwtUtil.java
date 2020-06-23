package com.webatoz.backend.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.stereotype.Component;

//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import java.security.Key;
//
public class JwtUtil {

  private final Key key;

  public JwtUtil(String secret) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String createToken(Integer userId, String name) {
    // TODO: JJWT 사용!

    String token = Jwts.builder()
        .claim("userId", userId)
        .claim("name",name)
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();

    return token;
  }
}
