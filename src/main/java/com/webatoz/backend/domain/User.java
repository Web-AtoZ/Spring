package com.webatoz.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String name;

    private Long boardId;

    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
