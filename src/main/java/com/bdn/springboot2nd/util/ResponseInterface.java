package com.bdn.springboot2nd.util;

import com.bdn.springboot2nd.util.dto.BaseResponse;
import org.springframework.http.HttpStatus;

public interface ResponseInterface {
    default BaseResponse<Object> defaultResponse(Object object){
        return new BaseResponse<>(String.valueOf(HttpStatus.OK.value()),
                "Success",
                null,
                object);
    }
}
