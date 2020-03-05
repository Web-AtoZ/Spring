package com.test.hello.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String createApp() {
        return "docker test !!!!";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello! docker test - update test";
    }

    @GetMapping("/students")
    public Student getStudents() {
        return new Student("john", 21, "010-9999-0000");
    }
  
  @GetMapping("/hello2")
  public String hello2() {
    return "hello! docker test - update test";
  }

}
