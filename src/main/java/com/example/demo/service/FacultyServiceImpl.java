package com.example.demo.service;

import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.FacultyMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Faculty;
import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private FacultyMapper mapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<FacultyDto> findAll() {
        return facultyRepository
                .findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public FacultyDto findById(Long id) {
        Faculty faculty = facultyRepository.getReferenceById(id);
        return mapper.map(faculty);
    }

    @Override
    public List<StudentDto> getStudentsByFacultyId(Long facultyId) {
        return facultyRepository
                .getReferenceById(facultyId)
                .getGroups()
                .stream()
                .map(Group::getStudents)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingLong(Student::getId))
                .map(studentMapper::map)
                .toList();
    }
}
