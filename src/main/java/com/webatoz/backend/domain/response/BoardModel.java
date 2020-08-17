package com.webatoz.backend.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.option.Option;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;

@Getter
@Relation(collectionRelation = "board")
public class BoardModel extends RepresentationModel<BoardModel> {

  @JsonProperty(value = "id")
  private final Integer boardId;
  private final String title;
  private final String content;
  private final Integer views;

  private final UserModel user;
  private final CategoryModel category;
  private final RestaurantModel restaurant;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime updatedDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime deletedDate;

  public BoardModel(Board board) {
    this.boardId = board.getBoardId();
    this.title = board.getTitle();
    this.content = board.getContent();
    this.views = board.getViews();
    this.createdDate = board.getCreatedDate();
    this.updatedDate = board.getUpdatedDate();
    this.deletedDate = board.getDeletedDate();
    this.user = new UserModel(board.getUser());
    this.category = board.getCategory() != null ? new CategoryModel(board.getCategory()) : null;
    this.restaurant = board.getRestaurant() != null ? new RestaurantModel(board.getRestaurant()) : null;
  }
}
