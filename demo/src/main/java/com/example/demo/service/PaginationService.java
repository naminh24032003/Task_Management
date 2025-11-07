package com.example.demo.service;


import com.example.demo.dtos.paginationDto.PageResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class PaginationService {

    public <T> PageResponseDto<T> getPaginatedData(JpaRepository<T, Long> repository, Pageable pageable) {
        Page<T> pageData = repository.findAll(pageable);

        return new PageResponseDto<>(
                pageData.getContent(),
                pageData.getNumber(),
                pageData.getSize(),
                pageData.getTotalElements(),
                pageData.getTotalPages(),
                pageData.isLast()
        );
    }
}
