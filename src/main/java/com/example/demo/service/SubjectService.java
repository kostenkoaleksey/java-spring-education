package com.example.demo.service;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> findAll();

    List<SubjectAverageMarkDto> listSubjectsWithAverageMarks();
}
