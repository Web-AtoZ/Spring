package com.webatoz.backend.domain.board;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBoardDomain {

  private String title;

  private String content;

  private Integer categoryId;

  private Integer restaurantId;

}
