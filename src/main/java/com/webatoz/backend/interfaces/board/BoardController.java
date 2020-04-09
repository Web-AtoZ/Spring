package com.webatoz.backend.interfaces.board;

import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.interfaces.common.BaseController;
import com.webatoz.backend.response.ResponseModel;
import com.webatoz.backend.services.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController extends BaseController {

  private final BoardService boardService;

  @GetMapping("/all")
  public ResponseEntity getBoard() {
    ResponseModel responseModel = successResponseModel("boards", boardService.getBoard());
    return ResponseEntity.ok(responseModel);
  }

  @PostMapping("")
  public boolean insertBoard(@RequestBody Board board) {
    System.out.println(board);
    return boardService.insertBoard(board) != 0;
  }
}
