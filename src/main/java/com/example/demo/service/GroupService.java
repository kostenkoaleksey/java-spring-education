package com.example.demo.service;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupGendersCountDto;
import com.example.demo.dto.GroupSubjectsDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GroupService {
    List<GroupDto> findAll(Pageable pageable);

    List<GroupAverageMarkDto> getGroupWithAverageMark(Pageable pageable);

    List<GroupSubjectsDto> getGroupsWithSubjectsAverageMark(Pageable pageable);

    List<GroupGendersCountDto> getGroupsWhereMaleStudentsPrevailsOverFemale(Pageable pageable);
}
