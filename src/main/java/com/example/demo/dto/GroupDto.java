package com.example.demo.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class GroupDto {
    @NonNull
    Long id;
    @NonNull
    String title;
}
