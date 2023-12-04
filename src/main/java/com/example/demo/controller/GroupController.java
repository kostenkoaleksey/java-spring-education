package com.example.demo.controller;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupGendersCountDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public List<GroupDto> list(@PageableDefault(sort = "id") Pageable pageable) {
        return groupService.findAll(pageable);
    }


    @GetMapping("/groups/average-marks")
    public List<GroupAverageMarkDto> listGroupsWithAverageMarks(@PageableDefault(sort = "id") Pageable pageable) {
        return groupService.getGroupWithAverageMark(pageable);
    }

    @GetMapping("/groups/subjects")
    public List<GroupSubjectsDto> listGroupsWithSubjects(@PageableDefault(sort = "id") Pageable pageable) {
        return groupService.getGroupsWithSubjectsAverageMark(pageable);
    }

    @GetMapping("/groups/male-prevails-female")
    public List<GroupGendersCountDto> listGroupsWhereMalePrevailsOverFemale(@PageableDefault(sort = "id") Pageable pageable) {
        return groupService.getGroupsWhereMaleStudentsPrevailsOverFemale(pageable);
    }
}
