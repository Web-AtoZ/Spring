package com.webatoz.backend.response;

import com.webatoz.backend.global.error.exeption.ErrorCode;
import com.webatoz.backend.response.common.HALEntityModel;
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
