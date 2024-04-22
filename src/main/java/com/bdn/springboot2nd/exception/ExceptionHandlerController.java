package com.bdn.springboot2nd.exception;

import com.bdn.springboot2nd.exception.dto.MessageConstant;
import com.bdn.springboot2nd.util.dto.BaseResponse;
import com.bdn.springboot2nd.util.dto.WrapperMessageResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Getter
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        MessageConstant constant = ex.getMessageConstant();
        WrapperMessageResponse error = WrapperMessageResponse.builder()
                .field(constant.getField())
                .message(constant.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new BaseResponse<>(
                                String.valueOf(HttpStatus.BAD_REQUEST.value()), "Error", "Request Failed!", error));
    }

    @ExceptionHandler(value = ModelAttributeException.class)
    public ResponseEntity<Object> handleModelAttribute(ModelAttributeException exception) {
        List<WrapperMessageResponse> errors = new ArrayList<>();
        for (int i = 0; i < exception.getErrors().size(); i++) {
            errors.add(
                    new WrapperMessageResponse(
                            exception.getErrors().get(i).getField(), exception.getErrors().get(i).getMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new BaseResponse<>(
                                String.valueOf(HttpStatus.BAD_REQUEST.value()), "Error", "Request Failed!", errors));
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseEntity<Object> handleBusinessException(BusinessException be) {
        List<WrapperMessageResponse> errors = new ArrayList<>();
        errors.add(new WrapperMessageResponse(be.getField(), be.getMessage()));
        return ResponseEntity.status(be.getHttpStatus())
                .body(new
                        BaseResponse<>(
                        String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        "Error",
                        "Request Failed!",
                        errors
                ));
    }
}