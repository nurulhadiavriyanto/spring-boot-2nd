package com.bdn.springboot2nd.barang.service.impl;

import com.bdn.springboot2nd.barang.dto.request.BarangRequest;
import com.bdn.springboot2nd.barang.mapper.BarangMapper;
import com.bdn.springboot2nd.barang.service.BarangService;
import com.bdn.springboot2nd.barang.specification.BarangSpecification;
import com.bdn.springboot2nd.exception.BusinessException;
import com.bdn.springboot2nd.exception.EntityNotFoundException;
import com.bdn.springboot2nd.exception.dto.MessageConstant;
import com.bdn.springboot2nd.oracle.entity.BarangEntity;
import com.bdn.springboot2nd.oracle.repository.BarangRepository;
import com.bdn.springboot2nd.util.PagingInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BarangServiceImpl implements BarangService, PagingInterface {
    private final BarangRepository repository;
    private final BarangMapper mapper;
    private final BarangSpecification specification;

    @Override
    @Transactional
    public BarangEntity createBarang(BarangRequest request) {
        BarangEntity result;
        try {
            if(Boolean.TRUE.equals(repository.existsByNama(request.getNama()))){
                throw new EntityNotFoundException(MessageConstant.NAMA_ALREADY_EXISTS);
            }

            BarangEntity entity = mapper.convertRequestToEntity(request);

            repository.save(entity);

            result = entity;
        } catch (BusinessException e) {
            throw new BusinessException(e.getField(), e.getMessage(), e.getHttpStatus());
        }
        return result;
    }

    @Override
    public Page<BarangEntity> getBarang(String search, Integer page, Integer limit, String orderBy, String sortBy) {
        if(sortBy == null || sortBy.trim().isEmpty()){
            sortBy = "nama";
        }

        if(orderBy == null || orderBy.trim().isEmpty()){
            orderBy = "DESC";
        }

        Pageable pageable = defaultPage(page, limit, sortBy + "|" + orderBy);
        Specification<BarangEntity> searchSpec = specification.searchSpec(search);

        return repository.findAll(searchSpec, pageable);
    }
}
