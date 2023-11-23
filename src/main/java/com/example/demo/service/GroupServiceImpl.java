package com.example.demo.service;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.SubjectMapper;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<GroupDto> findAll() {
        return groupRepository
                .findAll()
                .stream()
                .map(groupMapper::map)
                .toList();
    }

    @Override
    public List<GroupAverageMarkDto> getGroupWithAverageMark() {
        return groupRepository
                .findAll()
                .stream()
                .map(groupMapper::mapGroupAverageMark)
                .toList();
    }

    @Override
    public List<GroupSubjectsDto> getGroupsWithSubjects() {
        return groupRepository
                .findAll()
                .stream()
                .map(groupMapper::mapGroupSubjects)
                .toList();
    }
}
