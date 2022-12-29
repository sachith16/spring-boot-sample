package com.senani.demo.exception;

import org.springframework.http.ResponseEntity;

public class ApiRequestException extends RuntimeException {

    private final ApiErrors apiError;
    private String additionalDetails;

    public ApiRequestException(ApiErrors apiError, String additionalDetails) {
        this.apiError = apiError;
        this.additionalDetails = additionalDetails;
    }

    public ResponseEntity<Object> getResponse() {
        ErrorInfo errorInfo = new ErrorInfo(apiError.getErrorCode(),
                apiError.getErrorMessage(),
                apiError.getStatus().value(),
                additionalDetails);
        return new ResponseEntity<>(errorInfo, apiError.getStatus());
    }
}
