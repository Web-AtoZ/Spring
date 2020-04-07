package com.webatoz.backend.application.board;

import com.webatoz.backend.domain.Board;
import com.webatoz.backend.domain.BoardRepository;
import com.webatoz.backend.domain.User;
import com.webatoz.backend.domain.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
  @Autowired BoardRepository boardRepository;

  @Autowired UserRepository userRepository;

  public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
    this.boardRepository = boardRepository;
    this.userRepository = userRepository;
  }

  public List<Board> getBoards() {
    List<Board> boards = boardRepository.findAll();

    return boards;
  }

  public Board getBoard(Long boardId) {
    Board board = boardRepository.findById(boardId).orElse(null);

    User user = userRepository.findUserByBoard(boardId);
    board.addUser(user);
    return board;
  }

  public Board addBoard(Board board) {
    return boardRepository.save(board);
  }
}
