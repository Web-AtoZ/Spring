package com.test.hello.error.exeption;

public enum ErrorCode {
    SUCCESS(200, "S001", "Success"),
    // Common
    INTERNAL_SERVER_ERROR(500, "C001", "Server Error"),
    INVALID_TYPE_VALUE(400, "C002", "Invalid Type Value"),
    NOT_FOUND(404, "C003", "Not Found"),
    INVALID_INPUT_VALUE(400, "C004", "Invalid Input Value");

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
