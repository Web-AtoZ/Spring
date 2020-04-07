package com.webatoz.backend.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Board {

  @Id
  @GeneratedValue
  private Long boardId;
  private String title;
  private String content;
  private Long view;

  @Transient
  private User user;
  private int optionId;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private LocalDateTime deletedDate;

  public Board() {
  }

  public Board(String title, String content, long view) {
    this.title = title;
    this.content = content;
    this.view = view;
  }

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

  public void setBoardId(long boardId) {
    this.boardId = boardId;
  }
}
