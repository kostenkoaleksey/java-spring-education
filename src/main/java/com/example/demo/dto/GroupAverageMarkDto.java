package com.example.demo.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class GroupAverageMarkDto {
    Long id;
    String title;
    @NonNull
    Double averageMark;
}
