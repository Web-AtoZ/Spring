package com.webatoz.backend.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webatoz.backend.database.webatoz.board.Board;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;

@Getter
@Relation(collectionRelation = "boards")
public class BoardModel extends RepresentationModel<BoardModel> {

  @JsonProperty(value = "id")
  private final Integer boardId;
  private final String title;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime updatedDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime deletedDate;

  public BoardModel(Board board) {
    this.boardId = board.getBoardId();
    this.title = board.getTitle();
    this.createdDate = board.getCreatedDate();
    this.updatedDate = board.getUpdatedDate();
    this.deletedDate = board.getDeletedDate();
  }
}
