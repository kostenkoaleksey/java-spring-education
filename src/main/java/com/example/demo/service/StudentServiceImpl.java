package com.example.demo.service;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDto> findAll(Pageable pageable) {
        return studentRepository
                .findAll(pageable)
                .stream()
                .map(studentMapper::mapStudentToStudentDto)
                .toList();
    }

    @Override
    public List<StudentDto> listStudentsWithDraftArmyAge(Pageable pageable) {
        return studentRepository
                .findByAgeBetween(StudentService.startDraftArmyAge, StudentService.endDraftArmyAge, pageable)
                .stream()
                .map(studentMapper::mapStudentToStudentDto)
                .toList();
    }

    @Override
    public List<ExcellentStudentDto> listExcellentStudents(Pageable pageable) {
        return studentRepository
                .findExcellentStudents(StudentService.averageMarkForExcellentStudent, pageable)
                .stream()
                .map(studentMapper::mapStudentAverageMarkToExcellentStudentDto)
                .toList();
    }

    @Override
    public List<StudentDto> getStudentsByFacultyId(Long facultyId, Pageable pageable) {
        return studentRepository
                .findStudentsByFacultyId(facultyId, pageable)
                .stream()
                .map(studentMapper::mapStudentToStudentDto)
                .toList();
    }
}
