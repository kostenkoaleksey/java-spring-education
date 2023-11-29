package com.example.demo.service;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> findAll(Pageable pageable);

    List<SubjectAverageMarkDto> listSubjectsWithAverageMarks(Pageable pageable);
}
