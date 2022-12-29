package com.senani.demo.exception;

import org.springframework.http.HttpStatus;

public enum ApiErrors {
    INVALID_PAYMENT_AMOUNT("E80000", "Course Not Found", HttpStatus.NOT_FOUND);

    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus status;

    ApiErrors(String errorCode, String errorMessage, HttpStatus status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
