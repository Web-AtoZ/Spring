package com.webatoz.backend.services.board;

import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.board.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public List<Board> getBoard() {
    return boardRepository.findAll();
  }

  public int insertBoard(Board board) {
    Board insertedBoard = boardRepository.save(board);
    int result = 0;

    if (insertedBoard.getBoardId() != null) {
      result = insertedBoard.getBoardId();
    }

    return result;
  }
}
