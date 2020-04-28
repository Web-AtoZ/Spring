package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.domain.board.CreateBoardDomain;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Getter
@EqualsAndHashCode
public class Board {
    
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer boardId;

  private String title;

  private String content;

  private Integer views = 0;
  
  private Integer userId;

  private Integer optionId;

  @CreationTimestamp
  private LocalDateTime createdDate;

  @UpdateTimestamp
  private LocalDateTime updatedDate;

  private LocalDateTime deletedDate;
  
  public void setCreateData(CreateBoardDomain createBoardDomain) {
    this.title = createBoardDomain.getTitle();
    this.content = createBoardDomain.getContent();
    this.userId = createBoardDomain.getUserId();
    this.createdDate = LocalDateTime.now();
  }
}