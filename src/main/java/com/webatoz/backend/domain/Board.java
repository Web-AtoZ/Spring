package com.webatoz.backend.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board {

  @Id
  @GeneratedValue
  private Long boardId;
  private String title;
  private String content;
  private Long view;

  private Long userId;
  @Transient
  private User user;
  private Long optionId;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private LocalDateTime deletedDate;

  public Board(String title, String content, long view) {
    this.title = title;
    this.content = content;
    this.view = view;
  }
  public Board(Long boardId, String title, String content) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
  }

  public Board(Long boardId, String title, String content, Long view) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.view = view;
    this.createdDate = LocalDateTime.now();
  }

  public void addUser(User user) {
    this.user = user;
  }

  public void setBoardId(long boardId) {
    this.boardId = boardId;
  }

  public void updateInformation(String title, String content) {
    this.title=title;
    this.content=content;
  }
}
