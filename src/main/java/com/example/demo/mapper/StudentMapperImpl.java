package com.example.demo.mapper;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.model.projection.StudentAverageMark;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {
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
    public ExcellentStudentDto map(StudentAverageMark item) {
        return new ExcellentStudentDto(
                map(item.getStudent()),
                item.getAverageMark()
        );
    }
}
