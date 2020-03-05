package com.test.hello.interfaces.error;

import com.test.hello.error.exeption.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/error", produces = { "application/hal+json" })
public class TestErrorController {

    @GetMapping("")
    public String error() {
        throw new NotFoundException("####### TestErrorController error() #######");
    }
}
