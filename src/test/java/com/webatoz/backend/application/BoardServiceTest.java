package com.webatoz.backend.application;

import com.webatoz.backend.domain.Board;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BoardServiceTest {

    private BoardService boardService = new BoardService();
    @Test
    public void getBoard() {
        Board board = boardService.getBoard(1004L);

        assertThat(board.getId(), is(1004L));
    }
}