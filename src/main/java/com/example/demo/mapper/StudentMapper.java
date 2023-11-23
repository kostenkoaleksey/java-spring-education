package com.example.demo.mapper;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;

public interface StudentMapper {
    StudentDto map(Student student);

    ExcellentStudentDto mapExcellentStudent(Student student);
}
