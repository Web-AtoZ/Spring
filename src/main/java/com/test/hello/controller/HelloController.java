package com.test.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

    @GetMapping("/")
    public String createApp()  {
        return "docker test !!!!";
    }

    @GetMapping("/hello")
    public String hello()  {
        return "hello! docker test - update test";
    }

    @GetMapping("/hello2")
    public String hello2()  {
        return "hello! docker test - update test";
    }
}
