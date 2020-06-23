package com.webatoz.backend.database.webatoz.restaurant;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

//  private final JPAQueryFactory jpaQuery;

  @Override
  public Page<Restaurant> findRestaurant() {
    return null;
  }

  @Override
  public Page<Restaurant> findRestaurant(Restaurant restaurant, Pageable pageable) {
//    QRestaurant qRestaurant = new QRestaurant("restaurant");
//
//    QueryResults<Restaurant> result = jpaQuery.select(qRestaurant)
//        .where(containsString(qRestaurant.name, restaurant.getName()))
//        .where(eqString(qRestaurant.optionName, restaurant.getOptionName()))
//        .offset(pageable.getOffset())
//        .limit(pageable.getPageSize())
//        .fetchResults();
//
//    return new PageImpl<>(result.getResults(), pageable, result.getTotal());
    return null;

  }

  private BooleanExpression eqString(StringPath path, String value) {
    // 공백 제거 후 null 또는 "" 확인
    if (StringUtils.deleteWhitespace(value).isEmpty()) {
      return null;
    }
    return path.eq(value);
  }

  private BooleanExpression containsString(StringPath path, String value) {
    // 공백 제거 후 null 또는 "" 확인
    if (StringUtils.deleteWhitespace(value).isEmpty()) {
      return null;
    }
    return path.contains(value);
  }
}
