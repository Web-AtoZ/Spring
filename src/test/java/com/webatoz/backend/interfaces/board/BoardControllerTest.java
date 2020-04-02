package com.webatoz.backend.interfaces.board;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {
  @Autowired private MockMvc mvc;

  @Test
  public void 게시판조회() throws Exception {
    mvc.perform(get("/boards"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"board_id\":1004")))
        .andExpect(content().string(containsString("\"title\":\"Hello\"")))
        .andExpect(content().string(containsString("\"content\":\"hi\"")));
  }

  @Test
  public void detail() throws Exception {
    mvc.perform(get("/boards/1004"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"board_id\":1004")))
        .andExpect(content().string(containsString("\"title\":\"Hello\"")));

    mvc.perform(get("/boards/2020"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"board_id\":2020")))
        .andExpect(content().string(containsString("\"title\":\"boards\"")));
  }
}
