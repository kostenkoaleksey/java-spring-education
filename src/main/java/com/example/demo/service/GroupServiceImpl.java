package com.example.demo.service;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupGendersCountDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Set<GroupDto> findAll(Pageable pageable) {
        return groupRepository
                .findAll(pageable)
                .stream()
                .map(groupMapper::mapGroupToGroupDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<GroupAverageMarkDto> getGroupWithAverageMark(Pageable pageable) {
        return groupRepository
                .findGroupsWithAverageMark(pageable)
                .stream()
                .map(groupMapper::mapGroupAverageMarkToGroupAverageMarkDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<GroupSubjectsDto> getGroupsWithSubjectsAverageMark(Pageable pageable) {
        return groupRepository
                .findGroupsSubjectsWithAverageMark(pageable)
                .stream()
                .map(groupMapper::mapGroupAverageMarkPerSubjectToGroupSubjectsDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<GroupGendersCountDto> getGroupsWhereMaleStudentsPrevailsOverFemale(Pageable pageable) {
        return groupRepository
                .findGroupStudentsGenderPrevailing(Student.Sex.MALE, Student.Sex.FEMALE, pageable)
                .stream()
                .map(groupMapper::mapGroupGenderCountToGroupGendersCountDto)
                .collect(Collectors.toSet());
    }
}
