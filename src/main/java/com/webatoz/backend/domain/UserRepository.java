package com.webatoz.backend.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByBoard(Long boardId);
}
