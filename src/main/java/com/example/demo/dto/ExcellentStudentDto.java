package com.example.demo.dto;

import lombok.Value;

import java.util.List;

@Value
public class ExcellentStudentDto {
    StudentDto student;
    List<SubjectAverageMarkDto> subjects;
    Double averageMark;
}
