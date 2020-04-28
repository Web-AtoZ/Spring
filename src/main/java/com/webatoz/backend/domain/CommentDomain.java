package com.webatoz.backend.domain;

import com.webatoz.backend.database.webatoz.board.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
public class CommentDomain {

    private String title;
    private String text;

    public CommentDomain(String title, String text) {
        this.title = title;
        this.text = text;
    }

}
