package com.webatoz.backend.domain;

public class Board {
  private final Long boardId;
  private final String title;
  private final String content;
  private final Long view;
  private User user;

  public Board(Long boardId, String title, String content, Long view) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.view = view;
  }

  public Long getBoardId() {
    return boardId;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public Long getView() {
    return view;
  }
  public User getUser() {
    return user;
  }

  public void addUser(User user) {
    this.user = user;
  }

  //  private final int views
  //  private Date created_date
  //  private Date updated_date
  // private Date deleted_date
  // private final int user_id
  // private ifnal int option_id
  //    public Board (Long id, String title) {
  //        this.id = id;
  //        this.title = title;
  //    }
}
