package com.webatoz.backend.domain;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@RequiredArgsConstructor
public class BoardRepositoryTest {

    private final BoardRepository boardRepository;

    @Test
    public void create() {
        Board board = Board.builder()
                .title("hello")
                .content("testss")
                .views(0)
                .createdDate(LocalDateTime.now())
                .build();

        Board newBoard = boardRepository.save(board);
        System.out.println(newBoard);
        //assertThat(newBoard.getTitle(), is("hello"));
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}