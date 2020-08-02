package com.webatoz.backend.database.webatoz.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  private String account;

  private String name;

  private String email;

  private String secret;

  @CreationTimestamp
  private LocalDateTime createdDate;

  @UpdateTimestamp
  private LocalDateTime updatedDate;

  private LocalDateTime deletedDate;

  private String snsType;

  private String snsProfile;

//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  private Set<Board> boards = new HashSet<>();
}
