package com.webatoz.backend.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webatoz.backend.database.webatoz.users.Users;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;

@Getter
@Relation(collectionRelation = "user")
public class UserModel extends RepresentationModel<UserModel> {

  @JsonProperty(value = "id")
  private final Integer userId;
  private final String account;
  private final String name;
  private final String email;

  private final String snsType;
  private final String snsProfile;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime updatedDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime deletedDate;

  public UserModel(Users user) {
    this.userId = user.getUserId();
    this.account = user.getAccount();
    this.name = user.getName();
    this.email = user.getEmail();
    this.snsType = user.getSnsType();
    this.snsProfile = user.getSnsProfile();
    this.createdDate = user.getCreatedDate();
    this.updatedDate = user.getUpdatedDate();
    this.deletedDate = user.getDeletedDate();
  }
}
