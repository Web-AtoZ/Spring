package com.webatoz.backend.interfaces.user;

import com.webatoz.backend.application.user.UserService;
import com.webatoz.backend.database.webatoz.user.User;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.css.Styleable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/users")
  public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {

    String email = resource.getEmail();
    String name = resource.getName();
    String password = resource.getSecret();
    User user = userService.registerUser(
        email,
        name,
        password
    );
    String url = "/users/" + user.getId();
    return ResponseEntity.created(new URI(url)).body("{}");
  }
}