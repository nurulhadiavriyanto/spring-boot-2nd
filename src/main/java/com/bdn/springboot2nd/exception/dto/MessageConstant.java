package com.bdn.springboot2nd.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MessageConstant {
    NAMA_ALREADY_EXISTS( "Nama", "Nama sudah ada!", "400");

    private String field;
    private String message;
    private String httpStatus;
}