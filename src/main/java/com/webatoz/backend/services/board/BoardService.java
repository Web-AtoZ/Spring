package com.webatoz.backend.services.board;

import com.webatoz.backend.database.webatoz.board.Board;
import com.webatoz.backend.database.webatoz.board.BoardRepository;

import com.webatoz.backend.database.webatoz.category.Category;
import com.webatoz.backend.database.webatoz.category.CategoryRepository;
import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import com.webatoz.backend.database.webatoz.restaurant.RestaurantRepository;
import com.webatoz.backend.database.webatoz.users.UsersRepository;
import com.webatoz.backend.database.webatoz.users.Users;
import com.webatoz.backend.domain.board.BoardSearchDomain;
import com.webatoz.backend.domain.board.CreateBoardDomain;
import com.webatoz.backend.domain.board.UpdateBoardDomain;
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
  private final UsersRepository usersRepository;
  private final RestaurantRepository restaurantRepository;

  @Transactional(readOnly = true)
  public Page<Board> getBoards(BoardSearchDomain boardSearchDomain, Pageable pageable) {
    Page<Board> boards = boardRepository.findAllBySearch(boardSearchDomain, pageable);
    return boards;
  }

  @Transactional(readOnly = true)
  public Board getBoard(Integer boardNo) {
    Board board = boardRepository.findByBoardIdAndDeletedDateIsNull(boardNo);
    if (board == null) throw new NotFoundException("board does not exist.");
    return board;
  }

  @Transactional
  public Board createBoard(CreateBoardDomain boardDomain) {
    Board board = new Board();
    Category category = null;
    Restaurant restaurant = null;

    Users user = usersRepository.getOne(boardDomain.getUserId());
    if (user == null) throw new NotFoundException("user does not exist.");

    if (boardDomain.getCategoryId() != null) {
      category = categoryRepository.getOne(boardDomain.getCategoryId());
      if (category == null) throw new NotFoundException("category does not exist.");
    }
    if (boardDomain.getRestaurantId() != null) {
      restaurant = restaurantRepository.getOne(boardDomain.getRestaurantId());
      if (restaurant == null) throw new NotFoundException("restaurant does not exist.");
    }

    board.setCreateData(boardDomain, user, category, restaurant);
    return boardRepository.save(board);
  }

  @Transactional
  public Board updateBoard(Integer boardNo, UpdateBoardDomain boardDomain) {
    Board board = boardRepository.findByBoardIdAndDeletedDateIsNull(boardNo);
    Category category = null;
    Restaurant restaurant = null;

    if (board == null) throw new NotFoundException("board does not exist.");

    if (boardDomain.getCategoryId() != null) {
      category = categoryRepository.getOne(boardDomain.getCategoryId());
      if (category == null) throw new NotFoundException("category does not exist.");
    }

    if (boardDomain.getRestaurantId() != null) {
      restaurant = restaurantRepository.getOne(boardDomain.getRestaurantId());
      if (restaurant == null) throw new NotFoundException("restaurant does not exist.");
    }
    board.setUpdateData(boardDomain, category, restaurant);
    return boardRepository.save(board);
  }

  @Transactional
  public Board deleteBoard(Integer boardNo) {
    Board board = boardRepository.findByBoardIdAndDeletedDateIsNull(boardNo);
    if (board == null) throw new NotFoundException("board does not exist.");

    board.setDelteData();
    return boardRepository.save(board);
  }
}
