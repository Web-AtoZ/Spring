package com.webatoz.backend.interfaces.board;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.webatoz.backend.application.board.BoardService;
import com.webatoz.backend.domain.Board;
import com.webatoz.backend.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {
  @Autowired private MockMvc mvc;

  @MockBean private BoardService boardService;

  @Test
  public void 게시판조회() throws Exception {
    List<Board> boards = new ArrayList<>();
    boards.add(new Board(1004L, "Test", "hi", 0L));

    given(boardService.getBoards()).willReturn(boards);

    mvc.perform(get("/boards"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"board_id\":1004")))
        .andExpect(content().string(containsString("\"title\":\"Test\"")))
        .andExpect(content().string(containsString("\"content\":\"hi\"")))
        .andExpect(content().string(containsString("\"view\":0")));
  }

  @Test
  public void detail() throws Exception {
    Board board1 = new Board(1004L, "Test2", "hi", 0L);
    Board board2 = new Board(2020L, "boards", "hi", 0L);
    board1.addUser(new User(1L, "sbim"));
    board2.addUser(new User(1L, "sbim"));

    given(boardService.getBoard(1004L)).willReturn(board1);
    given(boardService.getBoard(2020L)).willReturn(board2);

    mvc.perform(get("/boards/1004"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"board_id\":1004")))
        .andExpect(content().string(containsString("\"title\":\"Test2\"")))
        .andExpect(content().string(containsString("sbim")));

    mvc.perform(get("/boards/2020"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"board_id\":2020")))
        .andExpect(content().string(containsString("\"title\":\"boards\"")));
  }

  @Test
  public void create() throws Exception {
    mvc.perform(post("/boards")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"title\":\"Hello\",\"content\":\"hi\",\"view\":0}"))
        .andExpect(status().isCreated())
        .andExpect(header().string("location", "/boards/1234"))
        .andExpect(content().string("{}"));

    verify(boardService).addBoard(any());
  }
}
