package com.webatoz.backend.database.webatoz.restaurant;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class Restaurant {

  @Id
  private Integer restaurantId;
  private String name;
  private LocalDate createdDate;
  private LocalDate updatedDate;
  private LocalDate deletedDate;
  private String address;
  private Double lng;
  private Double lat;
  private Integer optionId;
  private Integer boardId;
  private String roadAddress;
  private String optionName;
  private String phone;
  private String mapx;
  private String mapy;
}
