package com.bdn.springboot2nd.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private final String field;
    private final HttpStatus httpStatus;

    public BusinessException(String field, String message, HttpStatus httpStatus) {
        super(message);
        this.field = field;
        this.httpStatus = httpStatus;
    }
}