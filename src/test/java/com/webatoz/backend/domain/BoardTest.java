package com.webatoz.backend.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BoardTest {

  @Test
  public void creation() {
    Board board = new Board(1004L, "Hello", "Man");
    assertThat(board.getBoardId(), is(1004L));
    assertThat(board.getTitle(), is("Hello"));
    assertThat(board.getContent(), is("Man"));
  }
  //  @Test
  //  public void information() {
  //    Board board = new Board("Hello", "Man");
  //    assertThat(board.getInformation(), is("Hello"));
  //  }
}
