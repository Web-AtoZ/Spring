package com.test.hello.database.webatoz.anonymous;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Anonymous {
    @Id
    private String name;
}