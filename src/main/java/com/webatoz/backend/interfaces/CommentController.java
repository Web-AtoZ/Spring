package com.webatoz.backend.interfaces;

import com.webatoz.backend.domain.CommentDomain;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comments")
public class CommentController {

    public CommentDomain commentDomain;

    @GetMapping("/{no}")
    public CommentDomain getComment (@PathVariable("no") Integer commentNo) {
        System.out.println(commentNo);
        return commentDomain;
    }

    @PostMapping
    public CommentDomain setComment (@RequestBody CommentDomain comment) {
        System.out.println(comment);
        this.commentDomain = comment;
        return comment;
    }
}
