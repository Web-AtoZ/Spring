package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.domain.CreateBoardDomain;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer boardId;

  private String title;

  private String content;

  private Integer views;

  private Integer userId;

  private Integer optionId;

  private LocalDateTime createdDate;

  private LocalDateTime updatedDate;

  private LocalDateTime deletedDate;

//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
//  private User user;

  public void setCreateData(CreateBoardDomain createBoardDomain) {
    this.title = createBoardDomain.getTitle();
    this.content = createBoardDomain.getContent();
    this.userId = createBoardDomain.getUserId();
    this.createdDate = LocalDateTime.now();
  }

}
