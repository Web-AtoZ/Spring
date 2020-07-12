package com.webatoz.backend.domain.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashMap;
import java.util.Map;

public abstract class HALEntityModel extends RepresentationModel {

  private final Map<String, Object> embedded = new HashMap<>();
  private Object page = new Object();

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @JsonProperty("_embedded")
  public Map<String, Object> getEmbeddedModels() {
    return embedded;
  }

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @JsonProperty("page")
  public Object getPages() {
    return page;
  }

  public void embeddedModel(String relationship, Object resource) {
    embedded.put(relationship, resource);
  }

  public void page(PagedModel.PageMetadata metadata) {
    page =  metadata;
  }
}
