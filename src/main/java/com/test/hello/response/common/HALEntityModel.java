package com.test.hello.response.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashMap;
import java.util.Map;

public abstract class HALEntityModel extends RepresentationModel {

  private final Map<String, Object> embedded = new HashMap<>();

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @JsonProperty("_embedded")
  public Map<String, Object> getEmbeddedModels() {
    return embedded;
  }

  public void embeddedModel(String relationship, Object resource) {
    embedded.put(relationship, resource);
  }
}
