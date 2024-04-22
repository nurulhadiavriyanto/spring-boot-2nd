package com.bdn.springboot2nd.util.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class WrapperMessageResponse {
    private String field;
    private String message;
}