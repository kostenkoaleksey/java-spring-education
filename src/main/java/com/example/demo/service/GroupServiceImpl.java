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

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<GroupDto> findAll(Pageable pageable) {
        return groupRepository
                .findAll(pageable)
                .stream()
                .map(groupMapper::mapGroupToGroupDto)
                .toList();
    }

    @Override
    public List<GroupAverageMarkDto> getGroupWithAverageMark(Pageable pageable) {
        return groupRepository
                .findGroupsWithAverageMark(pageable)
                .stream()
                .map(groupMapper::mapGroupAverageMarkToGroupAverageMarkDto)
                .toList();
    }

    @Override
    public List<GroupSubjectsDto> getGroupsWithSubjectsAverageMark(Pageable pageable) {
        return groupRepository
                .findGroupsSubjectsWithAverageMark(pageable)
                .stream()
                .map(groupMapper::mapGroupAverageMarkPerSubjectToGroupSubjectsDto)
                .toList();
    }

    @Override
    public List<GroupGendersCountDto> getGroupsWhereMaleStudentsPrevailsOverFemale(Pageable pageable) {
        return groupRepository
                .findGroupStudentsGenderPrevailing(Student.Sex.MALE, Student.Sex.FEMALE, pageable)
                .stream()
                .map(groupMapper::mapGroupGenderCountToGroupGendersCountDto)
                .toList();
    }
}
