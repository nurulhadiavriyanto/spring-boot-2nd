package com.bdn.springboot2nd.barang.controller;

import com.bdn.springboot2nd.barang.dto.request.BarangRequest;
import com.bdn.springboot2nd.barang.dto.response.BarangResponse;
import com.bdn.springboot2nd.barang.mapper.BarangMapper;
import com.bdn.springboot2nd.barang.service.BarangService;
import com.bdn.springboot2nd.oracle.entity.BarangEntity;
import com.bdn.springboot2nd.util.BindingResultInterface;
import com.bdn.springboot2nd.util.ResponseInterface;
import com.bdn.springboot2nd.util.constant.SpringBoot2ndConstant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> getBarang(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) String sortBy){
        Page<BarangEntity> entities = service.getBarang(search, page, limit, orderBy, sortBy);

        List<BarangResponse> responses = mapper.convertToListResponse(entities);

        return ResponseEntity.ok(defaultResponse(new PageImpl<>(responses,
                entities.getPageable(), entities.getTotalElements())));
    }
}
