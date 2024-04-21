package com.bdn.springboot2nd.barang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BarangResponse {
    private String id;
    private String nama;
    private BigDecimal jumlah;
    private LocalDate kedaluwarsa;
    private LocalDateTime insertDate;
    private LocalDateTime lastUpdate;
}