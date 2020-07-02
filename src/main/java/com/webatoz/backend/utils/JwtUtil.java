package com.webatoz.backend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JwtUtil {

  private final Key key;

  public JwtUtil(String secret) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String createToken(Integer userId, String name) {
    // TODO: JJWT 사용!

    return Jwts.builder()
        .claim("userId", userId)
        .claim("name",name)
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  public Claims getClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(token)  //JWS = Signature 가 포함된 내용
        .getBody();
  }
}
