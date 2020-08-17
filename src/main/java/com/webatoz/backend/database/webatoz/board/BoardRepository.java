package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.domain.board.BoardSearchDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>, BoardRepositoryCustom {

    Board findByBoardIdAndDeletedDateIsNull(Integer boardId);
}
