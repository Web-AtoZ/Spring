package com.webatoz.backend.interfaces.user;

import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> create(
            @RequestBody User resource
    ) throws URISyntaxException {
        User user = userService.registerUser(resource);

        String url = "/users/"+user.getUserId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
//    public ResponseEntity<?> login (
//    Authentication authentication,
//    @RequestBody User resource) {
//     Claims claims = (Claims) authentication.getPrincipal();
//      String name = claims.get("name", String.class);
//    }
}