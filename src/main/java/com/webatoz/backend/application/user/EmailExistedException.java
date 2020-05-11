package com.webatoz.backend.application.user;

public class EmailExistedException extends RuntimeException{

  EmailExistedException(String email) {
    super("Email is already register" + email);
  }
}
