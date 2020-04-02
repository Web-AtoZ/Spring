package com.webatoz.backend.domain;

import java.util.List;

public interface BoardRepository {
    List<Board> findAll();

    Board findById(Long boardId);
}
