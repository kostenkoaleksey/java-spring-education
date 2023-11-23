package com.example.demo.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class GroupAverageMarkDto {
    GroupDto group;
    @NonNull
    Double averageMark;
}
