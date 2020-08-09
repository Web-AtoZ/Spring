package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.database.webatoz.category.Category;
import com.webatoz.backend.database.webatoz.users.Users;
import com.webatoz.backend.domain.board.CreateBoardDomain;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    private LocalDateTime deletedDate;


    /**
     * 게시글 등록
     * @param createBoardDomain
     */
    public void setCreateData(CreateBoardDomain createBoardDomain, Users user, Category category) {
        this.title = createBoardDomain.getTitle();
        this.content = createBoardDomain.getContent();
        this.user = user;
        this.category = category;
        this.createdDate = LocalDateTime.now();
    }
}