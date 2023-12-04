package com.example.demo.service;

import com.example.demo.dto.FacultyDto;
import com.example.demo.mapper.FacultyMapper;
import com.example.demo.model.Faculty;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private FacultyMapper facultyMapper;

    @Override
    public List<FacultyDto> findAll(Pageable pageable) {
        return facultyRepository
                .findAll(pageable)
                .stream()
                .map(facultyMapper::mapFacultyToFacultyDto)
                .toList();
    }

    @Override
    public FacultyDto findById(Long id) {
        Faculty faculty = facultyRepository.getReferenceById(id);
        return facultyMapper.mapFacultyToFacultyDto(faculty);
    }
}
