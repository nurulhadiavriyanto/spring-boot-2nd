package com.bdn.springboot2nd.util;

import com.bdn.springboot2nd.exception.ModelAttributeException;
import com.bdn.springboot2nd.util.dto.WrapperMessageResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public interface BindingResultInterface {
    default void isValid(BindingResult bindingResult){
        List<WrapperMessageResponse> wrapperMessages = null;
        if (bindingResult.hasErrors()) {
            wrapperMessages = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                wrapperMessages.add(new WrapperMessageResponse(fieldError.getField(), fieldError.getDefaultMessage()));
            }
            throw new ModelAttributeException(wrapperMessages);
        }
    }
}
