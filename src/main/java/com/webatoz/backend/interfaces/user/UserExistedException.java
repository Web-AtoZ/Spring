package com.webatoz.backend.interfaces.user;

public class UserExistedException extends RuntimeException {
    public UserExistedException(String email) {
        super("Email is already registered" + email);
    }
}
