package com.webatoz.backend.database.webatoz.restaurant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantRepositoryCustom {

  Page<Restaurant> findRestaurant();

  Page<Restaurant> findRestaurant(Restaurant restaurant, Pageable pageable);

  Page<Restaurant> findRestaurantsByNameLike(String restaurantName, Pageable pageable);
}
