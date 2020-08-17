package com.webatoz.backend.domain.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBoardDomain {

  @NotBlank(message = "title must not be blank.")
  private String title;

  @NotBlank(message = "content must not be blank.")
  private String content;

  @NotNull(message = "userId must not be null.")
  private Integer userId;

  private Integer categoryId;

  private Integer restaurantId;

}
