package com.bdn.springboot2nd.barang.controller;

import com.bdn.springboot2nd.barang.dto.request.BarangRequest;
import com.bdn.springboot2nd.barang.mapper.BarangMapper;
import com.bdn.springboot2nd.barang.service.BarangService;
import com.bdn.springboot2nd.oracle.entity.BarangEntity;
import com.bdn.springboot2nd.util.BindingResultInterface;
import com.bdn.springboot2nd.util.ResponseInterface;
import com.bdn.springboot2nd.util.constant.SpringBoot2ndConstant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SpringBoot2ndConstant.PATH_BARANG)
public class BarangController implements ResponseInterface, BindingResultInterface {
    private final BarangService service;
    private final BarangMapper mapper;

    @PostMapping
    public ResponseEntity<?> createBarang(@Valid @RequestBody BarangRequest request,
                                          BindingResult bindingResult)
    {
        this.isValid(bindingResult);

        BarangEntity entity = service.createBarang(request);

        return ResponseEntity.ok(defaultResponse(mapper.convertEntityToResponse(entity)));
    }
}
