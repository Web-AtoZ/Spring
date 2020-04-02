package com.webatoz.backend.interfaces.board;

import com.webatoz.backend.domain.Board;
import com.webatoz.backend.domain.BoardRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {

  private BoardRepository repository = new BoardRepository();

  @GetMapping
  public List<Board> list() {
    List<Board> boards = repository.findAll();

    return boards;
  }

  @GetMapping("/{id}")
  public Board detail(@PathVariable("id") Long boardId) throws Exception {
    Board board = repository.findById(boardId);

    return board;
  }
}
