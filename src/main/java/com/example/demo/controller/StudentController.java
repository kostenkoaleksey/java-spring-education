package com.example.demo.controller;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> list() {
        return studentService.findAll();
    }

    @GetMapping("/students/draft-army-age")
    public List<StudentDto> listStudentsOfDraftArmyAge() {
        return studentService.listStudentsWithDraftArmyAge();
    }

    @GetMapping("/students/excellent-students")
    public List<ExcellentStudentDto> listExcellentStudents() {
        return studentService.listExcellentStudents();
    }
}
