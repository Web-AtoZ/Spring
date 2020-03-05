package com.test.hello.controller.error;

import com.test.hello.error.exeption.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestErrorController {

    @GetMapping("/error")
    public String error() {
        throw new NotFoundException("####### TestErrorController error() #######");
    }
}
