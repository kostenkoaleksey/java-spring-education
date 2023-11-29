package com.example.demo.controller;

import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.FacultyService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/faculties")
    public List<FacultyDto> list(Pageable pageable) {
        return facultyService.findAll(pageable);
    }

    @GetMapping("/faculties/{facultyId}")
    public FacultyDto getFaculty(@PathVariable Long facultyId, Pageable pageable) {
        return facultyService.findById(facultyId, pageable);
    }

    @GetMapping("/faculties/{facultyId}/students")
    public Set<StudentDto> listFacultyStudents(@PathVariable Long facultyId, Pageable pageable) {
        return studentService.getStudentsByFacultyId(facultyId, pageable);
    }
}
