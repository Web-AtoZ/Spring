package com.webatoz.backend.database.webatoz.board;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data // 겟터 셋터 이콜, 해쉬
@Entity
public class Board {
  @Id @GeneratedValue private Integer boardId;

  private String title;

  private String content;

  private Integer views = 0;

  @CreationTimestamp private LocalDateTime createdDate;

  @UpdateTimestamp private LocalDateTime updatedDate;

  private LocalDateTime deletedDate;

  private Integer userId;

  private Integer optionId;
}
