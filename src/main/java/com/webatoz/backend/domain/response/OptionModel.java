package com.webatoz.backend.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.option.Option;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;

@Getter
@Relation(collectionRelation = "option")
public class OptionModel extends RepresentationModel<OptionModel> {

  @JsonProperty(value = "optionId")
  private final Integer optionId;
  private final Integer level;
  private final Integer order;
  private final String description;
  private final Integer pOptionId;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime updatedDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime deletedDate;

  public OptionModel(Option option) {
    this.optionId = option.getOptionId();
    this.level = option.getLevel();
    this.order = option.getOrder();
    this.description = option.getDescription();
    this.pOptionId = option.getPOptionId();
    this.createdDate = option.getCreatedDate();
    this.updatedDate = option.getUpdatedDate();
    this.deletedDate = option.getDeletedDate();
  }
}
