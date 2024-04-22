package com.bdn.springboot2nd.barang.mapper;

import com.bdn.springboot2nd.barang.dto.request.BarangRequest;
import com.bdn.springboot2nd.barang.dto.response.BarangResponse;
import com.bdn.springboot2nd.oracle.entity.BarangEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BarangMapper {
    public BarangEntity convertRequestToEntity(BarangRequest request) {
        return BarangEntity.builder()
                .nama(request.getNama())
                .jumlah(request.getJumlah())
                .kedaluwarsa(request.getKedaluwarsa())
                .insertDate(LocalDateTime.now())
                .build();
    }

    public BarangResponse convertEntityToResponse(BarangEntity entity) {
        return BarangResponse.builder()
                .id(entity.getId())
                .nama(entity.getNama())
                .jumlah(entity.getJumlah())
                .kedaluwarsa(entity.getKedaluwarsa())
                .insertDate(entity.getInsertDate())
                .lastUpdate(entity.getLastUpdate())
                .build();
    }

    public List<BarangResponse> convertToListResponse(Page<BarangEntity> page) {
        return page.stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }
}
