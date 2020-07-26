package com.webatoz.backend.database.webatoz.restaurant;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Projection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom{

  @Qualifier("webatozJPAQueryFactory")
  private final JPAQueryFactory jpaQuery;

  @Override
  public Page<Restaurant> findRestaurant() {
    return null;
  }

  @Override
  public Page<Restaurant> findRestaurant(Restaurant restaurant, Pageable pageable) {
    QRestaurant qRestaurant = new QRestaurant("restaurant");
    QueryResults<Restaurant> result = jpaQuery.selectFrom(qRestaurant)
        .where(containsString(qRestaurant.name, restaurant.getName()), eqString(qRestaurant.optionName, restaurant.getOptionName()))
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetchResults();

    return new PageImpl<>(result.getResults(), pageable, result.getTotal());
  }

  private BooleanExpression eqString(StringPath path, String value) {
    // 공백 제거 후 null 또는 "" 확인
    if (StringUtils.isEmpty(value)) {
      return null;
    }
    return path.eq(value);
  }

  private BooleanExpression containsString(StringPath path, String value) {
    // 공백 제거 후 null 또는 "" 확인
    if (StringUtils.isEmpty(value)) {
      return null;
    }
    return path.contains(value);
  }
}
