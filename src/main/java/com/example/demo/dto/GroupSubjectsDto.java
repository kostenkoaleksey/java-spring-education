package com.example.demo.dto;

import lombok.Value;

import java.util.List;
import java.util.Set;

@Value
public class GroupSubjectsDto {
    GroupDto group;
    Set<SubjectAverageMarkDto> subjects;
}
