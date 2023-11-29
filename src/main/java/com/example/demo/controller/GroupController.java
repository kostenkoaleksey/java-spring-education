package com.example.demo.controller;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupGendersCountDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public Set<GroupDto> list(Pageable pageable) {
        return groupService.findAll(pageable);
    }


    @GetMapping("/groups/average-marks")
    public Set<GroupAverageMarkDto> listGroupsWithAverageMarks(Pageable pageable) {
        return groupService.getGroupWithAverageMark(pageable);
    }

    @GetMapping("/groups/subjects")
    public Set<GroupSubjectsDto> listGroupsWithSubjects(Pageable pageable) {
        return groupService.getGroupsWithSubjectsAverageMark(pageable);
    }

    @GetMapping("/groups/male-prevails-female")
    public Set<GroupGendersCountDto> listGroupsWhereMalePrevailsOverFemale(Pageable pageable) {
        return groupService.getGroupsWhereMaleStudentsPrevailsOverFemale(pageable);
    }
}
