package com.example.demo.mapper;

import com.example.demo.dto.FacultyDto;
import com.example.demo.model.Faculty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FacultyMapperImpl implements FacultyMapper {
    @Override
    public FacultyDto map(Faculty faculty) {
        return new FacultyDto(
                faculty.getId(),
                faculty.getTitle()
        );
    }
}
