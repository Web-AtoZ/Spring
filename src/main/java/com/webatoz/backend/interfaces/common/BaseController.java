package com.webatoz.backend.interfaces.common;

import com.webatoz.backend.global.error.exeption.ErrorCode;
import com.webatoz.backend.domain.response.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class BaseController {

  protected static ResponseModel successResponseModel(String relationship, Object model, Link... links) {
    ResponseModel responseModel = new ResponseModel();
    responseModel.setCode(ErrorCode.SUCCESS.getCode());
    responseModel.setMessage(ErrorCode.SUCCESS.getMessage());
    responseModel.embeddedModel(relationship, model);
    responseModel.add(links);

    return responseModel;
  }

  protected static ResponseModel successResponseModel(String relationship, PagedModel model) {
    ResponseModel responseModel = new ResponseModel();
    responseModel.setCode(ErrorCode.SUCCESS.getCode());
    responseModel.setMessage(ErrorCode.SUCCESS.getMessage());
    responseModel.embeddedModel(relationship, model.getContent());
    responseModel.page(Objects.requireNonNull(model.getMetadata()));
    model.getLinks().forEach(responseModel::add);


    return responseModel;
  }
}
