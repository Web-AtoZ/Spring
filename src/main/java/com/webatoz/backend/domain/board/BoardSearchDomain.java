package com.webatoz.backend.domain.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardSearchDomain {

  private String title;
  private String content;
  private String userAccount;
  private Integer categoryId;

}
