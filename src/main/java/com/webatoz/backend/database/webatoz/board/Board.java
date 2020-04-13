package com.webatoz.backend.database.webatoz.board;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter
  private int boardId;
  private String title;
  private String content;
  private Integer views;

  private Long userId;
//  @Transient
//  private User user;
  private Long optionId;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private LocalDateTime deletedDate;

  public Board(String title, String content, Integer views) {
    this.title = title;
    this.content = content;
    this.views = views;
  }
  public Board(int boardId, String title, String content) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
  }

  public Board(int boardId, String title, String content, Integer views) {
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
