package com.webatoz.backend.interfaces.board;

import com.webatoz.backend.application.board.BoardService;
import com.webatoz.backend.domain.Board;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {

  @Autowired private BoardService boardService;

  @GetMapping
  public List<Board> list() {
    List<Board> boards = boardService.getBoards();
    return boards;
  }

  @GetMapping("/{id}")
  public Board detail(@PathVariable("id") Long boardId) throws Exception {
    Board board = boardService.getBoard(boardId);
    return board;
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Board resource) throws URISyntaxException {
    String title = resource.getTitle();
    String content = resource.getContent();
    long view = resource.getView();

    Board board = new Board(title, content, view);
    boardService.addBoard(board);

    URI location = new URI("/boards/"+ board.getBoardId());
    return ResponseEntity.created(location).body("{}");
  }
}
