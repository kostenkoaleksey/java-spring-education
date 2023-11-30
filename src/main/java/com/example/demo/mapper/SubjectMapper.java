package com.example.demo.mapper;

import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import com.example.demo.model.Subject;
import com.example.demo.model.projection.SubjectAverageMark;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectDto mapSubjectToSubjectDto(Subject subject);

    @Mapping(source = "subject.id", target = "id")
    @Mapping(source = "subject.title", target = "title")
    SubjectAverageMarkDto mapSubjectAverageMarkToSubjectAverageMarkDto(SubjectAverageMark subjectAverageMark);
}
