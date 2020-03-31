package com.webatoz.backend.interfaces.board;

import com.webatoz.backend.domain.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {

    @GetMapping
    public String list() {
        Board board = new Board(1L,"hi");
        return "hello";
    }
}
