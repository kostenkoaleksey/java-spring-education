package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.model.Group;
import com.example.demo.model.projection.GroupAverageMark;
import com.example.demo.model.projection.GroupAverageMarkPerSubject;
import com.example.demo.model.projection.GroupGenderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GroupMapperImpl implements GroupMapper {
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public GroupDto map(Long id, String title) {
        return new GroupDto(
                id,
                title
        );
    }

    @Override
    public GroupDto map(Group group) {
        return map(
                group.getId(),
                group.getTitle()
        );
    }

    @Override
    public GroupAverageMarkDto map(GroupAverageMark item) {
        return new GroupAverageMarkDto(
                map(item.getGroup()),
                item.getAverageMark()
        );
    }

    @Override
    public GroupSubjectsDto map(GroupAverageMarkPerSubject item) {
        Set<SubjectAverageMarkDto> subjects = item
                .getSubjectsAverageMark()
                .stream()
                .map(subjectMapper::mapSubjectAverageMark)
                .collect(Collectors.toSet());

        return new GroupSubjectsDto(
                map(
                        item.getId(),
                        item.getTitle()
                ),
                subjects
        );
    }

    @Override
    public GroupGendersCountDto map(GroupGenderCount item) {
        return new GroupGendersCountDto(
                map(item.getId(), item.getTitle()),
                item.getMaleCount(),
                item.getFemaleCount()
        );
    }
}
