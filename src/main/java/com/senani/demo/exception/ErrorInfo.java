package com.senani.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorInfo {
    private String code;
    private String message;
    private int httpStatusCode;
    private String additionalDetails;
}
