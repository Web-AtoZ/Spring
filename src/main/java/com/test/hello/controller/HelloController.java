package com.test.hello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController{

    @GetMapping("/")
    public String createApp()  {
        return "docker test !!!!";
    }

    @GetMapping("/hello")
    public String hello()  {
        return "hello! docker test - update test";
    }
 
}
