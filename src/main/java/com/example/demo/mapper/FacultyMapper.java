package com.example.demo.mapper;

import com.example.demo.dto.FacultyDto;
import com.example.demo.model.Faculty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    FacultyDto mapFacultyToFacultyDto(Faculty faculty);
}
