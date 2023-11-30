package com.example.demo.mapper;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.model.projection.StudentAverageMark;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto mapStudentToStudentDto(Student student);

    ExcellentStudentDto mapStudentAverageMarkToExcellentStudentDto(StudentAverageMark student);
}
