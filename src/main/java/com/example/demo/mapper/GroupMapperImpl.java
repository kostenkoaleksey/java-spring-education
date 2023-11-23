package com.example.demo.mapper;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.model.Group;
import com.example.demo.model.Mark;
import com.example.demo.model.Student;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class GroupMapperImpl implements GroupMapper {
    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private MarkService markService;

    @Override
    public GroupDto map(Group group) {
        return new GroupDto(
                group.getId(),
                group.getTitle()
        );
    }

    @Override
    public GroupAverageMarkDto mapGroupAverageMark(Group group) {
        List<Mark> groupMarks = group
                .getStudents()
                .stream()
                .map(Student::getMarks)
                .flatMap(Collection::stream)
                .toList();

        return new GroupAverageMarkDto(
                map(group),
                markService.getAverageMark(groupMarks)
        );
    }

    @Override
    public GroupSubjectsDto mapGroupSubjects(Group group) {
        List<Mark> groupMarks = group
                .getStudents()
                .stream()
                .map(Student::getMarks)
                .flatMap(Collection::stream)
                .toList();

        List<SubjectAverageMarkDto> subjects = markService.getSubjectsAverageMarks(groupMarks)
                .entrySet()
                .stream()
                .map(subjectMapper::mapSubjectAverageMark)
                .toList();

        return new GroupSubjectsDto(
                map(group),
                subjects
        );
    }
}
