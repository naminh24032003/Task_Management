package com.example.demo.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.dtos.paginationDto.PageRequestDto;

public class PaginationUtil {

    public static Pageable toPageable(PageRequestDto dto) {
        Sort sort = Sort.by(dto.getSortBy());
        sort = dto.getSortDirection().equalsIgnoreCase("DESC") ? sort.descending() : sort.ascending();
        return PageRequest.of(dto.getPage(), dto.getSize(), sort);
    }
}