package com.test.hello.interfaces.common;

import com.test.hello.error.exeption.ErrorCode;
import com.test.hello.reponse.common.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseController {

    protected ResponseModel createSuccessResponseModel(Link... links) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(ErrorCode.SUCCESS.getCode());
        responseModel.setMessage(ErrorCode.SUCCESS.getMessage());
        responseModel.add(links);
        return responseModel;
    }
}
