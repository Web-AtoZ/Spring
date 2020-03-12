package com.test.hello.interfaces;

import com.test.hello.domain.TestBodyDomain;
import com.test.hello.domain.TestDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloController {

  @GetMapping("/")
  public String createApp() {
    return "docker test !!!!";
  }

    /**
     * 예시호출 GET 127.0.0.1:8080/annotation?name=&numList=1,2,3,4
     * Body
     * {    "address": "test address",
     *      "inner": { "test" : "test", "test2" : "test2", "test3" : "test3" }
     * }
     */
  @GetMapping("/annotation")
  public TestDomain annotaionTest(
      @Valid TestDomain testDomain,
      @RequestBody TestBodyDomain testBodyDomain) {
    System.out.println("===========================");
    System.out.println(testDomain.getName());
    testDomain.getNumList().forEach(n -> System.out.println(n));
    System.out.println("===========================");
    System.out.println(testBodyDomain.getAddress());
    System.out.println(testBodyDomain.getInner().getTest());
    System.out.println(testBodyDomain.getInner().getTest2());
    System.out.println(testBodyDomain.getInner().getTest3());
    System.out.println("===========================");

    return testDomain;
  }
}
