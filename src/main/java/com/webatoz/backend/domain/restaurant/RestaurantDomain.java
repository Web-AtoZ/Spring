package com.webatoz.backend.domain.restaurant;

import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class RestaurantDomain extends RepresentationModel<RestaurantDomain> {
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

  public RestaurantDomain(String name, String optionName) {
    this.name = name;
    this.optionName = optionName;
  }

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
