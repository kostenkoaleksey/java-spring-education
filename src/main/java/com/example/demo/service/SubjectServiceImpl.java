package com.example.demo.service;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import com.example.demo.mapper.SubjectMapper;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper mapper;

    @Override
    public List<SubjectDto> findAll() {
        return subjectRepository
                .findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public List<SubjectAverageMarkDto> listSubjectsWithAverageMarks() {
        return subjectRepository
                .findAll()
                .stream()
                .map(mapper::mapSubjectAverageMark)
                .toList();
    }
}
