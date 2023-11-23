package com.example.demo.controller;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public List<SubjectDto> list() {
        return subjectService.findAll();
    }

    @GetMapping("/subjects/average-marks")
    public List<SubjectAverageMarkDto> listAverageMarks() {
        return subjectService.listSubjectsWithAverageMarks();
    }
}
