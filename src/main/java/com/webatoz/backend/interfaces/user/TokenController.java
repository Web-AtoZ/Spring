package com.webatoz.backend.interfaces.user;

//import com.webatoz.backend.utils.JwtUtil;
import com.webatoz.backend.database.webatoz.user.User;
import com.webatoz.backend.services.user.UserService;
import com.webatoz.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class TokenController {

    @Autowired
    private UserService userService;

      @Autowired
      private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<String> create(@RequestBody TokenRequestDto resource) throws URISyntaxException {

        String email = resource.getEmail();
        String secret = resource.getSecret();

        User user = userService.authenticate(email, secret);

        String accessToken = jwtUtil.createToken(user.getUserId(), user.getName());

        String url = "/token";
        return ResponseEntity.created(new URI(url)).body(accessToken);
    }
}
