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

//    boardService = new BoardService(boardRepository, userRepository);
  }

  private void mockBoardRepository() {
    List<Board> boards = new ArrayList<>();
    Board board = Board.builder()
            .boardId(1004)
            .title("Test2")
            .content("hi")
            .views(0).build();

    boards.add(board);

    given(boardRepository.findAll()).willReturn(boards);
    given(boardRepository.findById(1004)).willReturn(Optional.of(board));

  }

  private void mockUserRepository() {
    User user = new User(1L, "sbim");
    given(userRepository.findUserByBoard(1004L)).willReturn(user);
  }

  @Test
  public void getBoards() {
    List<Board> boards = boardService.getBoards();

    Board board = boards.get(0);
    assertThat(board.getBoardId(), is(1004));
  }

  @Test
  public void getBoard() {
    Board board = boardService.getBoard(1004);

    assertThat(board.getBoardId(), is(1004L));

//    User user = board.getUser();
//
//    assertThat(user.getName(), is("sbim"));
  }

  @Test
  public void addBoard() {
    given(boardRepository.save(any())).will(invocation -> {
      Board board = invocation.getArgument(0);
      board.setBoardId(1234);
      return board;
    });
    //given(boardRepository.save(any())).willReturn(saved);
    Board board = Board.builder()
            .title("Hello")
            .content("hi")
            .views(0)
            .build();
    //Board saved = new Board(1234L,"Hello", "hi", 0L);


    Board created = boardService.addBoard(board);

    assertThat(created.getBoardId(), is(1234));
  }

  @Test
  public void updateBoard() {
    Board board = Board.builder()
            .boardId(1004)
            .title("Test")
            .content("hi")
            .build();

    given(boardRepository.findById(1004)).willReturn(Optional.of(board));

    boardService.updateBoard(1004, "LoL", "test");

    assertThat(board.getTitle(), is("LoL"));
    assertThat(board.getContent(), is("test"));
  }
}
