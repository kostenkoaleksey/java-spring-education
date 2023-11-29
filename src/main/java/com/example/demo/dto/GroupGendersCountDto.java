package com.example.demo.dto;

import lombok.Value;

import java.util.Set;

@Value
public class GroupGendersCountDto {
    GroupDto group;
    Integer maleCount;
    Integer femaleCount;
}
