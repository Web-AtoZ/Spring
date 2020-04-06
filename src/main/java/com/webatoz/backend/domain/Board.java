package com.webatoz.backend.domain;

import java.time.LocalDateTime;

public class Board {
  private final Long boardId;
  private final String title;
  private final String content;
  private final Long view;
  private User user;
  private int optionId;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private LocalDateTime deletedDate;

  public Board(Long boardId, String title, String content, Long view) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.view = view;
    this.createdDate = LocalDateTime.now();
  }

  public Long getBoardId() {
    return boardId;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public Long getView() {
    return view;
  }
  public User getUser() {
    return user;
  }
  public int getOptionId() {
    return optionId;
  }
  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public LocalDateTime getUpdatedDate() {
    return updatedDate;
  }

  public LocalDateTime getDeletedDate() {
    return deletedDate;
  }

  public void addUser(User user) {
    this.user = user;
  }
}
