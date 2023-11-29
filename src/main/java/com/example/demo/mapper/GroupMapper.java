package com.example.demo.mapper;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupGendersCountDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.model.Group;
import com.example.demo.model.projection.GroupAverageMark;
import com.example.demo.model.projection.GroupAverageMarkPerSubject;
import com.example.demo.model.projection.GroupGenderCount;

public interface GroupMapper {
    GroupDto map(Long id, String title);

    GroupDto map(Group group);

    GroupAverageMarkDto map(GroupAverageMark item);

    GroupSubjectsDto map(GroupAverageMarkPerSubject item);

    GroupGendersCountDto map(GroupGenderCount item);
}
