package com.test.hello.interfaces;

import com.test.hello.domain.TestBodyDomain;
import com.test.hello.domain.TestDomain;
import com.test.hello.entity.Test;
import com.test.hello.interfaces.common.BaseController;
import com.test.hello.reponse.TestModel;
import com.test.hello.reponse.common.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class HelloController extends BaseController {

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

  @GetMapping(value = "/hateoas")
  public ResponseEntity getTestData() {

    Test test = new Test ();
    test.setTestData(1, "이정은", "주소");

    ResponseModel responseModel = createSuccessResponseModel(
            linkTo(methodOn(HelloController.class).getTestData()).withSelfRel(),
            linkTo(HelloController.class).slash("/docs/index.html#resources-name").withRel("profile")
    );

    responseModel.dataModel("test", new TestModel(test));

    return new ResponseEntity(responseModel, HttpStatus.OK);

  }
}
