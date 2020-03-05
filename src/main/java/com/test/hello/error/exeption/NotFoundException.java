package com.test.hello.error.exeption;

public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(message, ErrorCode.NOT_FOUND);
    }
}
