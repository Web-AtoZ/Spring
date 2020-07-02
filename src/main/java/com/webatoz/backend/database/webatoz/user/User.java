package com.webatoz.backend.database.webatoz.user;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import org.hibernate.annotations.ColumnDefault;

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

  private String account;

  private String name;

  private String email;

  private String secret;

  @ColumnDefault("webatoz")
  private String snsType;
  @ColumnDefault("/")
  private String snsProfile;

  private LocalDateTime createdDate;

  private LocalDateTime updatedDate;

  private LocalDateTime deletedDate;

//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  private Set<Board> boards = new HashSet<>();
}
