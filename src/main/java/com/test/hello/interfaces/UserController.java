package com.test.hello.interfaces;

import com.test.hello.services.anonymous.AnonymousService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AnonymousService anonymousService;

    @GetMapping("/user")
    public String getName() {
        return anonymousService.getName().getName();
    }

    @GetMapping("/user2")
    public String getName2() {
        return anonymousService.getName2();
    }
}