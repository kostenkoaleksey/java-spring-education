package com.example.demo.dto;

import com.example.demo.model.Student;
import lombok.NonNull;
import lombok.Value;

@Value
public class StudentDto {
    @NonNull
    Long id;
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    @NonNull
    Integer age;
    @NonNull
    Student.Sex sex;
}
