package com.bdn.springboot2nd.oracle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BARANG")
public class BarangEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "NAMA")
    private String nama;

    @Column(name = "JUMLAH")
    private BigDecimal jumlah;

    @Column(name = "KEDALUWARSA")
    private LocalDate kedaluwarsa;

    @Column(name = "INSERT_DATE")
    private LocalDateTime insertDate;

    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdate;
}