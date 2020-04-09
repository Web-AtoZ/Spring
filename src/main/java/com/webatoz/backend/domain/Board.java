package com.webatoz.backend.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter
  private int boardId;
  private String title;
  private String content;
  private int views;

  private Long userId;
//  @Transient
//  private User user;
  private Long optionId;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private LocalDateTime deletedDate;

  public Board(String title, String content, int views) {
    this.title = title;
    this.content = content;
    this.views = views;
  }
  public Board(int boardId, String title, String content) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
  }

  public Board(int boardId, String title, String content, int views) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.views = views;
    this.createdDate = LocalDateTime.now();
  }

  public void updateInformation(String title, String content) {
    this.title=title;
    this.content=content;
  }
}
