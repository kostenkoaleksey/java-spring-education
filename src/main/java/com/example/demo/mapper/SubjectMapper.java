package com.example.demo.mapper;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import com.example.demo.model.Subject;

import java.util.Map;

public interface SubjectMapper {
    SubjectDto map(Subject subject);

    SubjectAverageMarkDto mapSubjectAverageMark(Subject subject);

    SubjectAverageMarkDto mapSubjectAverageMark(Map.Entry<Subject, Double> mark);
}
