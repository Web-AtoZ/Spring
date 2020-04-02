package com.webatoz.backend.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardRepositoryImpl implements BoardRepository {

  List<Board> boards = new ArrayList<>();

  public BoardRepositoryImpl() {
    boards.add(new Board(1004L, "Hello", "hi", 0L));
    boards.add(new Board(2020L, "boards", "hi", 0L));
  }

  @Override
  public List<Board> findAll() {
    return boards;
  }

  @Override
  public Board findById(Long boardId) {
    return boards.stream()
        .filter(board -> board.getBoardId().equals(boardId))
        .findFirst()
        .orElse(null);
  }
}
