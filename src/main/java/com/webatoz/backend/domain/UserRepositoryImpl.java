package com.webatoz.backend.domain;

import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository{

    private User user = new User(1L, "sbim");

    @Override
    public User findUserByBoard(Long boardId) {
        return user;
    }

}
