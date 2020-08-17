package com.webatoz.backend.database.webatoz.restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Restaurant {

  @Id
  private Integer restaurantId;
  private String name;

  @CreationTimestamp
  private LocalDateTime createdDate;
  @UpdateTimestamp
  private LocalDateTime updatedDate;
  private LocalDateTime deletedDate;

  private String address;
  private Double lng;
  private Double lat;
  private Integer optionId;
  private String roadAddress;
  private String optionName;
  private String phone;
  private String placeId;

  public Restaurant(String name, String optionName) {
    this.name = name;
    this.optionName = optionName;
  }
}
