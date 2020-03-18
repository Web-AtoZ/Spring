package com.test.hello.reponse.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashMap;
import java.util.Map;

public abstract class HALEntityModel extends RepresentationModel {

    private final Map<String, Object> data = new HashMap<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("_data")
    public Map<String, Object> getDataModels() {
        return data;
    }

    public void dataModel(String relationship, Object resource) {
        data.put(relationship, resource);
    }
}
