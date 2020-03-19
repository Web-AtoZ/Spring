package com.webatoz.backend.global.testentity;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// @Table
public class Test {

  private Integer id;

  private String name;

  private String address;

  public void setTestData(Integer id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }
}
