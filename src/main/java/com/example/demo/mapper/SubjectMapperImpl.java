package com.example.demo.mapper;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import com.example.demo.model.Subject;
import com.example.demo.model.projection.SubjectAverageMark;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperImpl implements SubjectMapper {
    @Override
    public SubjectDto map(Subject subject) {
        return new SubjectDto(
                subject.getId(),
                subject.getTitle()
        );
    }

    @Override
    public SubjectAverageMarkDto mapSubjectAverageMark(SubjectAverageMark subject) {
        return new SubjectAverageMarkDto(
                map(subject.getSubject()),
                subject.getAverageMark()
        );
    }
}
