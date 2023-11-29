package com.example.demo.service;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface StudentService {
    Integer startDraftArmyAge = 20;
    Integer endDraftArmyAge = 27;

    Integer averageMarkForExcellentStudent = 90;

    Set<StudentDto> findAll(Pageable pageable);

    Set<StudentDto> listStudentsWithDraftArmyAge(Pageable pageable);
    Set<ExcellentStudentDto> listExcellentStudents(Pageable pageable);

    Set<StudentDto> getStudentsByFacultyId(Long facultyId, Pageable pageable);
}
