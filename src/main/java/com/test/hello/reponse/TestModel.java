package com.test.hello.reponse;

import com.test.hello.entity.Test;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Relation(collectionRelation = "test")
public class TestModel extends RepresentationModel<TestModel> {

    private final Integer id;
    private final String name;
    private final String address;

    public TestModel(Test test) {
        this.id = test.getId();
        this.name = test.getName();
        this.address = test.getAddress();
    }
}
