package com.webatoz.backend.interfaces.restaurant;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import com.webatoz.backend.domain.response.ResponseModel;
import com.webatoz.backend.interfaces.common.BaseController;
import com.webatoz.backend.services.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/restaurants")
@Slf4j
public class RestaurantController extends BaseController {

  private final RestaurantService restaurantService;

  // 식당 리스트 모두 가져오기
  @GetMapping
  public ResponseEntity<ResponseModel> getRestaurants(Restaurant restaurant, Pageable pageable) {

    // TODO 검색 조건 받도록 설정하기
    Page<Restaurant> restaurants = restaurantService.getRestaurants(pageable);
//    Page<Restaurant> restaurants = restaurantService.getRestaurants(restaurant, pageable);

    Link selfLink =
        linkTo(methodOn(RestaurantController.class).getRestaurants(restaurant, pageable)).withSelfRel();
    Link profileLink =
        linkTo(RestaurantController.class)
            .slash("/docs/index.html#resources-get-restaurants")
            .withRel("profile");

    ResponseModel responseResource =
        successResponseModel("restaurants", restaurants, selfLink, profileLink);

    return new ResponseEntity<>(responseResource, HttpStatus.OK);
  }
}
