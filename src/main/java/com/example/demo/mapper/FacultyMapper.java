package com.example.demo.mapper;

import com.example.demo.dto.FacultyDto;
import com.example.demo.model.Faculty;

public interface FacultyMapper {
    FacultyDto map(Faculty faculty);
}
