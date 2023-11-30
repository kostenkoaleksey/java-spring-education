package com.example.demo.dto;

import lombok.Value;

@Value
public class SubjectAverageMarkDto {
    Long id;
    String title;
    Double averageMark;
}
