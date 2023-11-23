package com.example.demo.service;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupSubjectsDto;

import java.util.List;

public interface GroupService {
    List<GroupDto> findAll();

    List<GroupAverageMarkDto> getGroupWithAverageMark();

    List<GroupSubjectsDto> getGroupsWithSubjects();
}
