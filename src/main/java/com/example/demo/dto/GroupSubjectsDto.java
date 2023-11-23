package com.example.demo.dto;

import lombok.Value;

import java.util.List;

@Value
public class GroupSubjectsDto {
    GroupDto group;
    List<SubjectAverageMarkDto> subjects;
}
