package com.webatoz.backend.interfaces.user;

public class EmailNotExistedException extends RuntimeException{

    public EmailNotExistedException(String email) {
        super("Email is not registered" + email);
    }
}
