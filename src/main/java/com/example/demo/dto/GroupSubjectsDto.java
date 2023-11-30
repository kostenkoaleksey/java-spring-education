package com.example.demo.dto;

import lombok.Value;

import java.util.Set;

@Value
public class GroupSubjectsDto {
    Long id;
    String title;
    Set<SubjectAverageMarkDto> subjects;
}
