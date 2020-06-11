package com.webatoz.backend.database.webatoz.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  private String id;

  private String name;

  private String email;

  private String secret;

  private String snsType;

  private String snsProfile;

  private LocalDateTime createdDate;

  private LocalDateTime updatedDate;

  private LocalDateTime deletedDate;

//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  private Set<Board> boards = new HashSet<>();
}
