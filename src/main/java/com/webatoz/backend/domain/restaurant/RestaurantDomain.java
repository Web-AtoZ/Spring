package com.webatoz.backend.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;

@Getter
@Relation(collectionRelation = "restaurant")
public class RestaurantDomain extends RepresentationModel<RestaurantDomain> {
  private Integer restaurantId;
  private String name;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime updatedDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime deletedDate;
  private String address;
  private Double lng;
  private Double lat;
  private Integer optionId;
  private String roadAddress;
  private String optionName;
  private String phone;

  public RestaurantDomain(Restaurant restaurant) {
    this.restaurantId = restaurant.getRestaurantId();
    this.name = restaurant.getName();
    this.createdDate = restaurant.getCreatedDate();
    this.updatedDate = restaurant.getUpdatedDate();
    this.deletedDate = restaurant.getDeletedDate();
    this.address = restaurant.getAddress();
    this.lng = restaurant.getLng();
    this.lat = restaurant.getLat();
    this.optionId = restaurant.getOptionId();
    this.roadAddress = restaurant.getRoadAddress();
    this.phone = restaurant.getPhone();
  }
}
