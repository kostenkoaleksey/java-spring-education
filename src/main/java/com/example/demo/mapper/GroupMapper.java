package com.example.demo.mapper;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.model.Group;
import com.example.demo.model.Subject;

import java.util.Map;

public interface GroupMapper {
    GroupDto map(Group group);
    GroupAverageMarkDto mapGroupAverageMark(Group group);

    GroupSubjectsDto mapGroupSubjects(Group group);
}
