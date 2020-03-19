package com.test.hello.response;

import com.test.hello.error.exeption.ErrorCode;
import com.test.hello.response.common.HALEntityModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel extends HALEntityModel {

  private String code;
  private String message;

  public ResponseModel(ErrorCode code) {
    this.code = code.getCode();
    this.message = code.getMessage();
  }
}
