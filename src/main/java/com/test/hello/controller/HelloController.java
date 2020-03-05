package com.test.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController{

    @GetMapping("/")
    public String createApp()  {
        log.info("Hello");
        log.error("error");
        return "docker test !!!!";
    }

    @GetMapping("/hello")
    public String hello()  {
        return "hello! docker test - update test";
    }
 
}
