package com.example.demo.service;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;

import java.util.List;

public interface StudentService {
    Integer startDraftArmyAge = 20;
    Integer endDraftArmyAge = 27;

    List<StudentDto> findAll();

    List<StudentDto> listStudentsWithDraftArmyAge();
    List<ExcellentStudentDto> listExcellentStudents();
}
