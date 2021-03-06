package com.webatoz.backend.database.webatoz.board;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.webatoz.backend.database.webatoz.category.QCategory;
import com.webatoz.backend.database.webatoz.common.ExpressionUtil;
import com.webatoz.backend.database.webatoz.restaurant.QRestaurant;
import com.webatoz.backend.database.webatoz.users.QUsers;
import com.webatoz.backend.domain.board.BoardSearchDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryImpl implements BoardRepositoryCustom {

  private final JPAQueryFactory queryFactory;
  private final QBoard board;
  private final QUsers users;
  private final QCategory category;
  private final QRestaurant restaurant;

  public BoardRepositoryImpl(JPAQueryFactory queryFactory) {
    this.queryFactory = queryFactory;
    this.board = QBoard.board;
    this.users = QUsers.users;
    this.category = QCategory.category;
    this.restaurant = QRestaurant.restaurant;
  }

  @Override
  public Page<Board> findAllBySearch(BoardSearchDomain boardSearchDomain, Pageable pageable) {

    JPAQuery query = queryFactory
            .selectFrom(board).distinct()
            .innerJoin(board.user, users).fetchJoin()
            .leftJoin(board.category, category)
            .leftJoin(board.restaurant, restaurant)
            .where(
                    ExpressionUtil.like(board.title, boardSearchDomain.getTitle()),
                    ExpressionUtil.like(board.content, boardSearchDomain.getContent()),
                    ExpressionUtil.like(board.user.account, boardSearchDomain.getUserAccount()),
                    ExpressionUtil.eq(board.category.categoryId, boardSearchDomain.getCategoryId()),
                    board.deletedDate.isNull()
            );

    long totalCount = query.fetchCount();

    query
            .orderBy(board.createdDate.desc(), board.updatedDate.desc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize());

    return new PageImpl<>(query.fetch(), pageable, totalCount);
  }
}
