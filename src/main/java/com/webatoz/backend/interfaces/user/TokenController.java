package com.webatoz.backend.interfaces.user;

//import com.webatoz.backend.utils.JwtUtil;
import com.webatoz.backend.services.user.UserService;
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
//  @Autowired
//  private JwtUtil jwtUtil;
// String accessToken = jwtUtil.createToken(1004L, "john");

    @PostMapping("/token")
    public ResponseEntity<TokenResponseDto> create(@RequestBody TokenRequestDto resource) throws URISyntaxException {
        String accessToken = "ACCESSTOKEN";

        String email = resource.getEmail();
        String secret = resource.getSecret();

        userService.authenticate(email,secret);

        TokenResponseDto tokenDto = TokenResponseDto.builder()
                .accessToken(accessToken)
                .build();

        String url = "/token";
        return ResponseEntity.created(new URI(url)).body(tokenDto);
    }
}
