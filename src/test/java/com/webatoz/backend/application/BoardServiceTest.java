package com.webatoz.backend.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.webatoz.backend.application.board.BoardService;
import com.webatoz.backend.domain.Board;
import com.webatoz.backend.domain.BoardRepository;
import com.webatoz.backend.domain.User;
import com.webatoz.backend.domain.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BoardServiceTest {

  private BoardService boardService;

  @Mock private BoardRepository boardRepository;

  @Mock private UserRepository userRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockBoardRepository();
    mockUserRepository();

    boardService = new BoardService(boardRepository, userRepository);
  }

  private void mockBoardRepository() {
    List<Board> boards = new ArrayList<>();
    Board board = new Board(1004L, "Test2", "hi", 0L);
    boards.add(board);

    given(boardRepository.findAll()).willReturn(boards);
    given(boardRepository.findById(1004L)).willReturn(Optional.of(board));

  }

  private void mockUserRepository() {
    User user = new User(1L, "sbim");
    given(userRepository.findUserByBoard(1004L)).willReturn(user);
  }

  @Test
  public void getBoards() {
    List<Board> boards = boardService.getBoards();

    Board board = boards.get(0);
    assertThat(board.getBoardId(), is(1004L));
  }

  @Test
  public void getBoard() {
    Board board = boardService.getBoard(1004L);

    assertThat(board.getBoardId(), is(1004L));

    User user = board.getUser();

    assertThat(user.getName(), is("sbim"));
  }

  @Test
  public void addBoard() {
    Board board = new Board("Hello", "hi", 0L);
    Board saved = new Board(1234L,"Hello", "hi", 0L);

    given(boardRepository.save(any())).willReturn(saved);

    Board created = boardService.addBoard(board);

    assertThat(created.getBoardId(), is(1234L));
  }
}
