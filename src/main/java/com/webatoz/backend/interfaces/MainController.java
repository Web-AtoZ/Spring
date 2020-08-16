package com.webatoz.backend.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

  @GetMapping("/")
  public String hello(){
    return "hi, there";
  }
}
