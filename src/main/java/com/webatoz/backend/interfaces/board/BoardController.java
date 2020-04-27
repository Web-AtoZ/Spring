package com.webatoz.backend.interfaces.board;

import com.webatoz.backend.database.webatoz.board.Board;

import com.webatoz.backend.domain.CreateBoardDomain;
import com.webatoz.backend.interfaces.common.BaseController;
import com.webatoz.backend.response.BoardModel;
import com.webatoz.backend.response.ResponseModel;
import com.webatoz.backend.services.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/boards")
public class BoardController extends BaseController {

  private final BoardService boardService;

  // 등록
  @PostMapping
  public ResponseEntity createBoard(@Valid @RequestBody CreateBoardDomain createBoardDomain) {
    Board createResult = boardService.createBoard(createBoardDomain);

    Link selfLink =
        linkTo(methodOn(BoardController.class).createBoard(createBoardDomain)).withSelfRel();
    Link profileLink =
        linkTo(BoardController.class)
            .slash("/docs/index.html#resources-create-board")
            .withRel("profile");

    ResponseModel responseResource =
        successResponseModel("board", new BoardModel(createResult), selfLink, profileLink);

    return new ResponseEntity(responseResource, HttpStatus.CREATED);
  }

  // 목록 조회 (커스텀)
  @GetMapping
  public ResponseEntity getBoards(
      @PageableDefault(size = 10) Pageable pageable, PagedResourcesAssembler<Board> assembler) {
    Page<Board> boards = boardService.getBoards(pageable);

    var pagedModel = assembler.toModel(boards, board -> new BoardModel(board));

    pagedModel.add(
        linkTo(BoardController.class)
            .slash("/docs/index.html#resources-get-boards")
            .withRel("profile"));

    return ResponseEntity.ok().body(pagedModel);
  }

  // 목록 조회 (select 해온 모든 컬럼 return)
  @GetMapping("/2")
  public ResponseEntity getBoardLinks(
      @PageableDefault(size = 10) Pageable pageable, PagedResourcesAssembler<Board> assembler) {
    Page<Board> boards = boardService.getBoards(pageable);
    return ResponseEntity.ok().body(assembler.toModel(boards));
}
