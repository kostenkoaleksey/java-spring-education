package com.example.demo.service;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private MarkService markService;

    @Override
    public List<StudentDto> findAll() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::map)
                .toList();
    }

    @Override
    public List<StudentDto> listStudentsWithDraftArmyAge() {
        return studentRepository
                .findByAgeBetweenOrderByAge(StudentService.startDraftArmyAge, StudentService.endDraftArmyAge)
                .stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .map(studentMapper::map)
                .toList();
    }

    @Override
    public List<ExcellentStudentDto> listExcellentStudents() {
        return studentRepository
                .findAll()
                .stream()
                .filter(s -> markService.getAverageMark(s.getMarks()) >= 90)
                .sorted(Comparator.comparingLong(Student::getId))
                .map(studentMapper::mapExcellentStudent)
                .toList();
    }
}
