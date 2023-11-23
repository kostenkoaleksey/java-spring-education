package com.example.demo.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class SubjectAverageMarkDto {
    @NonNull
    SubjectDto subject;
    Double averageMark;
}
