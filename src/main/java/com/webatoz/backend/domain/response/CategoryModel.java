package com.webatoz.backend.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webatoz.backend.database.webatoz.category.Category;
import com.webatoz.backend.database.webatoz.option.Option;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;

@Getter
@Relation(collectionRelation = "option")
public class CategoryModel extends RepresentationModel<CategoryModel> {

  @JsonProperty(value = "id")
  private final Integer categoryId;
  private final String name;
  private final String description;
  private final Integer pCategoryId;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime updatedDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime deletedDate;

  public CategoryModel(Category category) {
    this.categoryId = category.getCategoryId();
    this.name = category.getName();
    this.description = category.getDescription();
    this.pCategoryId = category.getPCategoryId();
    this.createdDate = category.getCreatedDate();
    this.updatedDate = category.getUpdatedDate();
    this.deletedDate = category.getDeletedDate();
  }
}
