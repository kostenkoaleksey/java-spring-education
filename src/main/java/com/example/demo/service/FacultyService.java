package com.example.demo.service;

import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> findAll(Pageable pageable);

    FacultyDto findById(Long id);
}
