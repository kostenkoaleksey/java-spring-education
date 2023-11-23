package com.example.demo.mapper;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.model.Mark;
import com.example.demo.model.Student;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapperImpl implements StudentMapper {
    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private MarkService markService;

    public StudentDto map(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getSex()
        );
    }

    @Override
    public ExcellentStudentDto mapExcellentStudent(Student student) {
        List<Mark> studentMarks = student.getMarks();
        List<SubjectAverageMarkDto> subjects = markService
                .getSubjectsAverageMarks(studentMarks)
                .entrySet()
                .stream()
                .map(subjectMapper::mapSubjectAverageMark)
                .toList();

        return new ExcellentStudentDto(
                map(student),
                subjects,
                markService.getAverageMark(studentMarks)
        );
    }
}
