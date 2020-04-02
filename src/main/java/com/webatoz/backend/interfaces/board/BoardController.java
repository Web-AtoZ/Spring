package com.webatoz.backend.interfaces.board;

import com.webatoz.backend.domain.Board;
import com.webatoz.backend.domain.BoardRepository;
import java.util.List;

import com.webatoz.backend.domain.User;
import com.webatoz.backend.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<Board> list() {
    List<Board> boards = boardRepository.findAll();

    return boards;
  }

  @GetMapping("/{id}")
  public Board detail(@PathVariable("id") Long boardId) throws Exception {
    // Board board = boardService.getBoardById(id);
    Board board = boardRepository.findById(boardId);

    User user = userRepository.findUserByBoard(id);
    board.addUser(new User(1L,"sbim"));
    return board;
  }
}
