package com.webatoz.backend.interfaces.common;

import com.webatoz.backend.global.error.exeption.ErrorCode;
import com.webatoz.backend.response.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseController {

  protected ResponseModel successResponseModel(String relationship, Object model, Link... links) {
    ResponseModel responseModel = new ResponseModel();
    responseModel.setCode(ErrorCode.SUCCESS.getCode());
    responseModel.setMessage(ErrorCode.SUCCESS.getMessage());
    responseModel.embeddedModel(relationship, model);
    responseModel.add(links);

    return responseModel;
  }
}
