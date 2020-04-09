package com.webatoz.backend.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BoardTest {

  @Test
  public void creation() {
    //Board board = new Board(1004L, "Hello", "Man", 0L);
    Board board = Board.builder()
            .boardId(1004)
            .title("Hello")
            .content("Man")
            .views(0)
            .build();

    assertThat(board.getBoardId(), is(1004));
    assertThat(board.getTitle(), is("Hello"));
    assertThat(board.getContent(), is("Man"));
    assertThat(board.getViews(), is(0));
  }
  //  @Test
  //  public void information() {
  //    Board board = new Board("Hello", "Man");
  //    assertThat(board.getInformation(), is("Hello"));
  //  }
}
