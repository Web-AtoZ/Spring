package com.webatoz.backend.global.error.exeption;

import lombok.Getter;

@Getter
public class InvalidInputException extends RuntimeException {

    private String field;
    private String value;
    private String reason;

    public InvalidInputException(String field, String value, String reason) {
        this.field = field;
        this.value = value;
        this.reason = reason;
    }
}
