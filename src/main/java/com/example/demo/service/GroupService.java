package com.example.demo.service;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupGendersCountDto;
import com.example.demo.dto.GroupSubjectsDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface GroupService {
    Set<GroupDto> findAll(Pageable pageable);

    Set<GroupAverageMarkDto> getGroupWithAverageMark(Pageable pageable);

    Set<GroupSubjectsDto> getGroupsWithSubjectsAverageMark(Pageable pageable);
    Set<GroupGendersCountDto> getGroupsWhereMaleStudentsPrevailsOverFemale(Pageable pageable);
}
