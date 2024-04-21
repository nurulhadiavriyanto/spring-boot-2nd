package com.bdn.springboot2nd.exception;

import com.bdn.springboot2nd.util.dto.WrapperMessageResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class ModelAttributeException extends RuntimeException{
    private final List<WrapperMessageResponse> errors;

    public ModelAttributeException(List<WrapperMessageResponse> wrapperMessages) {
        super();
        this.errors = wrapperMessages;
    }
}