package com.example.demo.service;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Integer startDraftArmyAge = 20;
    Integer endDraftArmyAge = 27;

    Integer averageMarkForExcellentStudent = 90;

    List<StudentDto> findAll(Pageable pageable);

    List<StudentDto> listStudentsWithDraftArmyAge(Pageable pageable);

    List<ExcellentStudentDto> listExcellentStudents(Pageable pageable);

    List<StudentDto> getStudentsByFacultyId(Long facultyId, Pageable pageable);
}
