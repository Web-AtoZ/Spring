package com.webatoz.backend.application;

import com.webatoz.backend.domain.Board;
import com.webatoz.backend.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id);
        return board;
    }
}
