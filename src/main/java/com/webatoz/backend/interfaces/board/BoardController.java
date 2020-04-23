package com.webatoz.backend.interfaces.board;

import com.webatoz.backend.application.board.BoardService;
import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.interfaces.common.BaseController;
import com.webatoz.backend.response.ResponseModel;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/boards")
@RequiredArgsConstructor
public class BoardController extends BaseController {

  private final BoardService boardService;

  @GetMapping
  public ResponseEntity list() {
    //List<Board> boards = boardService.getBoards();
    ResponseModel responseModel = successResponseModel("boards", boardService.getBoards());

    return ResponseEntity.ok(responseModel);
  }

  @GetMapping("/{id}")
  public ResponseEntity detail(@PathVariable("id") int boardId) throws Exception {
    Board board = boardService.getBoard(boardId);

    return ResponseEntity.ok().body(board);
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Board resource) throws URISyntaxException {
    Board board = Board.builder()
            .title(resource.getTitle())
            .content(resource.getContent())
            .views(0)
            .userId(resource.getUserId())
            .optionId(resource.getOptionId())
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .build();

    boardService.addBoard(board);

    URI location = new URI("/boards/"+ board.getBoardId());
    return ResponseEntity.created(location).body("{}");
  }

  @PatchMapping("/{id}")
  public String update(@PathVariable("id") int id, @RequestBody Board resource) {
    String title = resource.getTitle();
    String content = resource.getContent();
    boardService.updateBoard(id, title, content);
    return "{}";
  }
}
