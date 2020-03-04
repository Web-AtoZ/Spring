package com.test.hello.interfaces;

import com.test.hello.mapper.AnonymousMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnonymousController {

    @Autowired
    AnonymousMapper anonymousMapper;

    @GetMapping("/user")
    public String getName() {
        return anonymousMapper.find(1).getName();
    }
}
