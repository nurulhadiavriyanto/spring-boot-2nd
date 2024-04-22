package com.bdn.springboot2nd.barang.specification;

import com.bdn.springboot2nd.oracle.entity.BarangEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class BarangSpecification {
    public Specification<BarangEntity> searchSpec(String search) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new LinkedList<>();

            if(search != null && !search.trim().isEmpty()) {
                Predicate nama = builder.like(builder.upper(root.get("nama")), "%" + search.toUpperCase() + "%");
                Predicate jumlah = builder.like(builder.function("TO_CHAR", String.class, root.get("jumlah")), "%" + search + "%");
                Predicate kedaluwarsa = builder.like(builder.function("TO_CHAR", String.class, root.get("kedaluwarsa"), builder.literal("yyyy-MM-dd HH:mm:ss")), "%" + search + "%");

                predicates.add(builder.or(nama, jumlah, kedaluwarsa));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
