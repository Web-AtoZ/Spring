package com.webatoz.backend.domain;

public interface UserRepository {
    User findUserByBoard(Long boardId);
}
