package com.bdn.springboot2nd.oracle.repository;

import com.bdn.springboot2nd.oracle.entity.BarangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<BarangEntity, Long> {
    boolean existsByNama(String nama);
}
