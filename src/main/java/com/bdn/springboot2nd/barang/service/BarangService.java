package com.bdn.springboot2nd.barang.service;

import com.bdn.springboot2nd.barang.dto.request.BarangRequest;
import com.bdn.springboot2nd.oracle.entity.BarangEntity;

public interface BarangService {
    BarangEntity createBarang(BarangRequest request);
}
