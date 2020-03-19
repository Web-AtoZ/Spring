package com.webatoz.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
