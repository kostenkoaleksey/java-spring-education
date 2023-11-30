package com.example.demo.mapper;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupGendersCountDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.model.Group;
import com.example.demo.model.projection.GroupAverageMark;
import com.example.demo.model.projection.GroupAverageMarkPerSubject;
import com.example.demo.model.projection.GroupGenderCount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SubjectMapper.class})
public interface GroupMapper {
    GroupDto mapGroupToGroupDto(Group group);

    @Mapping(source = "group", target = ".")
    GroupAverageMarkDto mapGroupAverageMarkToGroupAverageMarkDto(GroupAverageMark item);

    @Mapping(source = "subjectsAverageMark", target = "subjects")
    GroupSubjectsDto mapGroupAverageMarkPerSubjectToGroupSubjectsDto(GroupAverageMarkPerSubject item);

    GroupGendersCountDto mapGroupGenderCountToGroupGendersCountDto(GroupGenderCount item);
}
