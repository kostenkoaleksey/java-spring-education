package com.example.demo.controller;

import com.example.demo.dto.GroupAverageMarkDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.GroupSubjectsDto;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public List<GroupDto> list() {
        return groupService.findAll();
    }


    @GetMapping("/groups/average-marks")
    public List<GroupAverageMarkDto> listGroupsWithAverageMarks() {
        return groupService.getGroupWithAverageMark();
    }

    @GetMapping("/groups/subjects")
    public List<GroupSubjectsDto> listGroupsWithSubjects() {
        return groupService.getGroupsWithSubjects();
    }
}
