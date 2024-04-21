package com.bdn.springboot2nd.barang.dto.request;

import com.bdn.springboot2nd.barang.constant.BarangConstant;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BarangRequest {
    @NotEmpty(message = BarangConstant.NAMA_REQUIRED)
    private String nama;

    @NotNull(message = BarangConstant.JUMLAH_REQUIRED)
    private BigDecimal jumlah;

    @NotNull(message = BarangConstant.KEDALUWARSA_REQUIRED)
    private LocalDate kedaluwarsa;
}
