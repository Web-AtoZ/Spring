package com.webatoz.backend.interfaces.user;

import java.net.URI;
import java.net.URISyntaxException;
import javafx.css.Styleable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @PostMapping("/users")
  public ResponseEntity<?> create() throws URISyntaxException {
    String email = "tester@example.com";
    String name = "Tester";
    String password = "test";
    User user = User.builder()
                .email(email)
                .name(name)
                .password(password);
    String url ="/users/"+ user.getId();
    return ResponseEntity.created(new URI(url)).body("{}");
  }
}
