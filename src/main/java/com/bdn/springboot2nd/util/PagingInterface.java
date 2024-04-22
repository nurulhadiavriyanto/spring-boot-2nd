package com.bdn.springboot2nd.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface PagingInterface {
    default Pageable defaultPage(Integer page, Integer limit, String sortBy) {
        page = (page != null) ? page : 0;
        limit = (limit != null) ? limit : 5;

        String[] properties = sortBy.split("\\|");
        Sort.Order order;
        if ("asc".equalsIgnoreCase(properties[1])) {
            order = new Sort.Order(Sort.Direction.ASC, properties[0]);
        } else {
            order = new Sort.Order(Sort.Direction.DESC, properties[0]);
        }
        Sort sort = Sort.by(order);
        return PageRequest.of(page, limit, sort);
    }
}
