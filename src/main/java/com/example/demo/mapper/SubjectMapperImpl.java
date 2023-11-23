package com.example.demo.mapper;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import com.example.demo.model.Subject;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SubjectMapperImpl implements SubjectMapper {
    @Autowired
    private MarkService markService;

    @Override
    public SubjectDto map(Subject subject) {
        return new SubjectDto(
                subject.getId(),
                subject.getTitle()
        );
    }

    @Override
    public SubjectAverageMarkDto mapSubjectAverageMark(Map.Entry<Subject, Double> mark) {
        Subject subject = mark.getKey();
        Double averageMark = mark.getValue().doubleValue();
        return new SubjectAverageMarkDto(
                map(subject),
                averageMark
        );
    }

    @Override
    public SubjectAverageMarkDto mapSubjectAverageMark(Subject subject) {
        return new SubjectAverageMarkDto(
                map(subject),
                markService.getAverageMark(subject.getMarks())
        );
    }
}
