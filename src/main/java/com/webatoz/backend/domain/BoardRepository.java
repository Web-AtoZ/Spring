package com.webatoz.backend.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
  List<Board> findAll();

  Optional<Board> findById(Long boardId);

  Board save(Board any);
}
