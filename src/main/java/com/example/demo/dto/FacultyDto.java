package com.example.demo.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class FacultyDto {
    @NonNull
    Long id;
    @NonNull
    String title;
}
