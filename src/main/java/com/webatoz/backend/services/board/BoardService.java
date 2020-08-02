package com.webatoz.backend.services.board;

import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.board.BoardRepository;

import com.webatoz.backend.database.webatoz.category.Category;
import com.webatoz.backend.database.webatoz.category.CategoryRepository;
import com.webatoz.backend.database.webatoz.option.OptionRepository;
import com.webatoz.backend.database.webatoz.user.UserRepository;
import com.webatoz.backend.database.webatoz.user.Users;
import com.webatoz.backend.domain.board.CreateBoardDomain;
import com.webatoz.backend.global.error.exeption.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final CategoryRepository categoryRepository;
  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public Page<Board> getBoards(Pageable pageable) {
    Page<Board> boards = boardRepository.findAll(pageable);
    return boards;
  }

  @Transactional(readOnly = true)
  public Board getBoard(Integer boardNo) {
    return boardRepository.getOne(boardNo);
  }

  @Transactional
  public Board createBoard(CreateBoardDomain boardDomain) {
    Board board = new Board();
    Users user = userRepository.getOne(boardDomain.getUserId());
    if (user == null) throw new NotFoundException("user does not exist.");
    Category category = categoryRepository.getOne(boardDomain.getCategoryId());
    if (category == null) throw new NotFoundException("category does not exist.");
    board.setCreateData(boardDomain, user, categoryRepository.getOne(boardDomain.getCategoryId()));
    return boardRepository.save(board);
  }
}
