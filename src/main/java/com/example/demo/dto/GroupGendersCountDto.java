package com.example.demo.dto;

import lombok.Value;

@Value
public class GroupGendersCountDto {
    Long id;
    String title;
    Integer maleCount;
    Integer femaleCount;
}
