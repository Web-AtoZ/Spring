package com.test.hello.interfaces.common;

import com.test.hello.entity.Test;
import com.test.hello.response.ResponseModel;
import com.test.hello.response.TestModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(
    value = "/hateoas",
    produces = {"application/hal+json"})
public class HeteoasTestController extends BaseController {

  // 조회
  @GetMapping("/{hateoasId}")
  public ResponseEntity getData(@PathVariable("hateoasId") Integer hateoasId) {

    Test test = getTestData();

    Link profileLink =
        linkTo(HeteoasTestController.class)
            .slash("/docs/index.html#resources-name")
            .withRel("profile");

    Link selfLink = linkTo(methodOn(HeteoasTestController.class).getData(hateoasId)).withSelfRel();

    Link listLink = linkTo(methodOn(HeteoasTestController.class).listData()).withRel("list-test");

    Link createLink =
        linkTo(methodOn(HeteoasTestController.class).createData(new Test())).withRel("create-test");

    Link updateLink =
        linkTo(methodOn(HeteoasTestController.class).updateData(hateoasId, new Test()))
            .withRel("update-test");

    Link deleteLink =
        linkTo(methodOn(HeteoasTestController.class).deleteData(hateoasId, new Test()))
            .withRel("delete-test");

    ResponseModel responseModel =
        successResponseModel(
            "test",
            new TestModel(test),
            profileLink,
            selfLink,
            listLink,
            createLink,
            updateLink,
            deleteLink);

    return ResponseEntity.ok(responseModel);
  }

  // 목록
  @GetMapping("/list")
  public ResponseEntity listData() {

    return new ResponseEntity(HttpStatus.OK);
  }

  // 등록
  @PostMapping
  public ResponseEntity createData(@RequestBody Test test) {
    return new ResponseEntity(HttpStatus.CREATED);
  }

  // 수정
  @PutMapping(value = "/{hateoasId}")
  public ResponseEntity updateData(
      @PathVariable("hateoasId") Integer hateoasId, @RequestBody Test test) {
    return new ResponseEntity(HttpStatus.OK);
  }

  // 삭제
  @DeleteMapping(value = "/{hateoasId}")
  public ResponseEntity deleteData(
      @PathVariable("hateoasId") Integer hateoasId, @RequestBody Test test) {
    return new ResponseEntity(HttpStatus.OK);
  }

  private Test getTestData() {
    Test test = new Test();
    test.setTestData(1, "이정은", "주소");
    return test;
  }
}
