package com.senani.demo.exception;

public class ApiExceptions {

    private ApiExceptions() {
    }

    public static final ApiRequestException COURSE_NOT_FOUND = new ApiRequestException(ApiErrors.INVALID_PAYMENT_AMOUNT, "Check with a correct id");

}
