package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.domain.board.BoardSearchDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
  Page<Board> findAllBySearch(BoardSearchDomain boardSearchDomain, Pageable pageable);
}
