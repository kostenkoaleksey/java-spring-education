package com.example.demo.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class SubjectDto {
    @NonNull
    Long id;
    @NonNull
    String title;
}
