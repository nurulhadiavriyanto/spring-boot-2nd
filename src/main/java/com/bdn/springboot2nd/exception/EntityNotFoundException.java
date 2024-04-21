package com.bdn.springboot2nd.exception;

import com.bdn.springboot2nd.exception.dto.MessageConstant;
import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException{
    private MessageConstant messageConstant;

    public EntityNotFoundException(String msg) {
        super(msg);
    }

    public EntityNotFoundException(MessageConstant messageConstant) {
        this(messageConstant.getMessage());
        this.messageConstant = messageConstant;
    }
}