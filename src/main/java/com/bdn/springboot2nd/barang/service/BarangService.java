package com.bdn.springboot2nd.barang.service;

import com.bdn.springboot2nd.barang.dto.request.BarangRequest;
import com.bdn.springboot2nd.oracle.entity.BarangEntity;
import org.springframework.data.domain.Page;

public interface BarangService {
    BarangEntity createBarang(BarangRequest request);
    Page<BarangEntity> getBarang(String search, Integer page, Integer limit, String orderBy, String sortBy);
}
