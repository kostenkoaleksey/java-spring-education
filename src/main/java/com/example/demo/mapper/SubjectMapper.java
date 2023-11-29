package com.example.demo.mapper;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import com.example.demo.model.Subject;
import com.example.demo.model.projection.SubjectAverageMark;

public interface SubjectMapper {
    SubjectDto map(Subject subject);

    SubjectAverageMarkDto mapSubjectAverageMark(SubjectAverageMark subject);
}
