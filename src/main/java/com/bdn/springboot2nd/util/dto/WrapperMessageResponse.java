package com.bdn.springboot2nd.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class WrapperMessageResponse {
    private String field;
    private String message;
}