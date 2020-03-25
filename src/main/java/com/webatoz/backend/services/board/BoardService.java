package com.webatoz.backend.services.board;

import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.board.BoardRepository;
import com.webatoz.backend.domain.CreateBoardDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional(readOnly = true)
  public Page<Board> getBoards(Pageable pageable) {
    Page<Board> boards = boardRepository.findAll(pageable);
    return boards;
  }

  @Transactional
  public Board createBoard(CreateBoardDomain boardDomain) {
    Board board = new Board();
    board.setCreateData(boardDomain);
    return boardRepository.save(board);
  }
}
