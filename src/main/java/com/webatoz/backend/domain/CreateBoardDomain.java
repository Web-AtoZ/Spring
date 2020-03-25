package com.webatoz.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBoardDomain {

  @NotBlank(message = "title must not be blank.")
  private String title;

  @NotBlank(message = "content must not be blank.")
  private String content;

  private Integer userId;

}
