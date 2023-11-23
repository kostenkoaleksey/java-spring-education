package com.example.demo.service;

import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> findAll();

    FacultyDto findById(Long id);

    List<StudentDto> getStudentsByFacultyId(Long facultyId);
}
