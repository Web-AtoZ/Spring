package com.test.hello.interfaces;

import com.test.hello.domain.TestDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloController {

  @GetMapping("/")
  public String createApp() {
    return "docker test !!!!";
  }

  @GetMapping("/annotation")
  public TestDomain annotaionTest(
          @Valid TestDomain testDomain
  ) {
    return testDomain;
  }
}
