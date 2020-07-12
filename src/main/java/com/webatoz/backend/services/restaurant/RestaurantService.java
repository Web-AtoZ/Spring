package com.webatoz.backend.services.restaurant;

import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import com.webatoz.backend.database.webatoz.restaurant.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;


  @Transactional(readOnly = true)
  public Page<Restaurant> getRestaurants(Pageable pageable) {
    Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);
    return restaurants;
  }

  public Page<Restaurant> getRestaurants(Restaurant restaurant, Pageable pageable) {

    return restaurantRepository.findRestaurant(restaurant, pageable);
  }
}
