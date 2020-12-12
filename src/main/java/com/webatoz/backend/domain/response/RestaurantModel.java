package com.webatoz.backend.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Relation(collectionRelation = "board")
public class RestaurantModel extends RepresentationModel<RestaurantModel> {

  @JsonProperty(value = "id")
  private final Integer restaurantId;
  private final String name;
  private final String address;
  private final Double lng;
  private final Double lat;
  private final Integer optionId;
  private final String roadAddress;
  private final String optionName;
  private final String phone;
  private final String placeId;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private final LocalDate createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private final LocalDate updatedDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private final LocalDate deletedDate;

  public RestaurantModel(Restaurant restaurant) {
    this.restaurantId = restaurant.getRestaurantId();
    this.name = restaurant.getName();
    this.address = restaurant.getAddress();
    this.lng = restaurant.getLng();
    this.lat = restaurant.getLat();
    this.optionId = restaurant.getOptionId();
    this.roadAddress = restaurant.getRoadAddress();
    this.optionName = restaurant.getOptionName();
    this.phone = restaurant.getPhone();
    this.placeId = restaurant.getPlaceId();
    this.createdDate = restaurant.getCreatedDate();
    this.updatedDate = restaurant.getUpdatedDate();
    this.deletedDate = restaurant.getDeletedDate();
  }
}
