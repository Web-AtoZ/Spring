package com.webatoz.backend.domain;

public class User {
    private final Long userId;
    private final String name;

    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }
}
