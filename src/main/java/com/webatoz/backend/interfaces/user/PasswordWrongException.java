package com.webatoz.backend.interfaces.user;

public class PasswordWrongException extends RuntimeException {
    public PasswordWrongException() {
        super("Password is wrong");
    }
}
