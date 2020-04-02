package com.webatoz.backend.domain;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {

  List<Board> boards = new ArrayList<>();

  public BoardRepository() {
    boards.add(new Board(1004L, "Hello", "hi"));
    boards.add(new Board(2020L, "boards", "hi"));
  }

  public List<Board> findAll() {
    return boards;
  }

  public Board findById(Long boardId) {
    return boards.stream()
        .filter(board -> board.getBoardId().equals(boardId))
        .findFirst()
        .orElse(null);
  }
}
