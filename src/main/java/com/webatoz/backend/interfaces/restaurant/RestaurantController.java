package com.webatoz.backend.interfaces.restaurant;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import com.webatoz.backend.domain.response.ResponseModel;
import com.webatoz.backend.domain.restaurant.RestaurantDomain;
import com.webatoz.backend.interfaces.common.BaseController;
import com.webatoz.backend.services.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/restaurants")
@Slf4j
public class RestaurantController extends BaseController {

  private final RestaurantService restaurantService;

//  // 식당 리스트 모두 가져오기
//  @GetMapping
//  public ResponseEntity<ResponseModel> getRestaurants(
//      RestaurantDomain restaurant,
//      @PageableDefault(size = 10) Pageable pageable,
//      PagedResourcesAssembler<Restaurant> assembler) {
//
//    Restaurant restaurant1 = new Restaurant(restaurant.getName(), restaurant.getOptionName());
//
//    Page<Restaurant> restaurants =
//        restaurantService.getRestaurants(restaurant1, pageable);
//    PagedModel<RestaurantDomain> pagedModel = assembler.toModel(restaurants, RestaurantDomain::new);
//
//    pagedModel.add(
//        linkTo(methodOn(RestaurantController.class).getRestaurants(restaurant, pageable, assembler))
//            .withSelfRel(),
//        linkTo(RestaurantController.class)
//            .slash("/docs/index.html#resources-get-restaurants")
//            .withRel("profile"));
//
//    ResponseModel responseResource = successResponseModel("restaurants", pagedModel);
//
//    return new ResponseEntity<>(responseResource, HttpStatus.OK);
//  }

  @GetMapping
  public ResponseEntity<ResponseModel> getRestaurants(
          @RequestParam(value = "name") String restaurantName,
          @PageableDefault(size = 10) Pageable pageable,
          PagedResourcesAssembler<Restaurant> assembler
  ) {
    Page<Restaurant> restaurants =
            restaurantService.getRestaurantsByNameLike(restaurantName, pageable);
    PagedModel<RestaurantDomain> pagedModel = assembler.toModel(restaurants, RestaurantDomain::new);

    ResponseModel responseResource = successResponseModel("restaurants", pagedModel);

    return new ResponseEntity<>(responseResource, HttpStatus.OK);

  }

}
