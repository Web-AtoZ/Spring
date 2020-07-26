package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.database.webatoz.option.Option;
import com.webatoz.backend.domain.board.CreateBoardDomain;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


@Entity
@Getter
@EqualsAndHashCode(of = "boardId", callSuper = false)
//@Where(clause = "deleted_date = null")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;

    private String title;

    private String content;

    private Integer views = 0;

    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "optionId")
    private Option option;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    private LocalDateTime deletedDate;


    /**
     * 게시글 등록
     * @param createBoardDomain
     */
    public void setCreateData(CreateBoardDomain createBoardDomain, Option option) {
        this.title = createBoardDomain.getTitle();
        this.content = createBoardDomain.getContent();
        this.userId = createBoardDomain.getUserId();
        this.option = option;
//        this.createdDate = LocalDateTime.now();
    }
}