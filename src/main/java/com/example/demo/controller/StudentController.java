package com.example.demo.controller;

import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> list(@PageableDefault(sort = "id") Pageable pageable) {
        return studentService.findAll(pageable);
    }

    @GetMapping("/students/draft-army-age")
    public List<StudentDto> listStudentsOfDraftArmyAge(@PageableDefault(sort = "id") Pageable pageable) {
        return studentService.listStudentsWithDraftArmyAge(pageable);
    }

    @GetMapping("/students/excellent-students")
    public List<ExcellentStudentDto> listExcellentStudents(@PageableDefault(sort = "id") Pageable pageable) {
        return studentService.listExcellentStudents(pageable);
    }
}
