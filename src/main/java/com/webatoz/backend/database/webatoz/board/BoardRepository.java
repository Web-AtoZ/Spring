package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.database.webatoz.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
//  List<Board> findAll();
//
//  Optional<Board> findById(Long boardId);
//
//  Board save(Board any);
}
