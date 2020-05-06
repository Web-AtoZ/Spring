package com.webatoz.backend.interfaces.user;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<?> create() throws URISyntaxException {

        URI location = new URI("/users/2");
        return ResponseEntity.created(location).body("{}");
    }
}
