package com.example.demo.controller;

import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.FacultyService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/faculties")
    public List<FacultyDto> list() {
        return facultyService.findAll();
    }

    @GetMapping("/faculties/{facultyId}")
    public FacultyDto getFaculty(@PathVariable Long facultyId) {
        return facultyService.findById(facultyId);
    }

    @GetMapping("/faculties/{facultyId}/students")
    public List<StudentDto> listFacultyStudents(@PathVariable Long facultyId) {
        return facultyService.getStudentsByFacultyId(facultyId);
    }
}
