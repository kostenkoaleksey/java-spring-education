package com.example.demo.controller;

import com.example.demo.BaseTestcontainers;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class GroupControllerTest extends BaseTestcontainers {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnListOfGroups_WhenDefaultPageable() {
        ResponseEntity<GroupDto[]> response = restTemplate.getForEntity("/groups", GroupDto[].class);
        HttpHeaders headers = response.getHeaders();
        GroupDto[] groups = response.getBody();

        assertTrue(headers.getContentType().includes(MediaType.APPLICATION_JSON));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(4, groups.length);
        Arrays.stream(groups)
                .forEach(g -> {
                    assertInstanceOf(GroupDto.class, g);
                });
    }

    @Test
    void shouldReturnListOfGroupsWithAverageMarks_WhenDefaultPageable() {
        ResponseEntity<GroupAverageMarkDto[]> response = restTemplate.getForEntity("/groups/average-marks", GroupAverageMarkDto[].class);
        HttpHeaders headers = response.getHeaders();
        GroupAverageMarkDto[] groups = response.getBody();

        assertTrue(headers.getContentType().includes(MediaType.APPLICATION_JSON));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(4, groups.length);
        Arrays.stream(groups)
                .forEach(g -> {
                    assertNotNull(g.getAverageMark());
                    assertInstanceOf(GroupAverageMarkDto.class, g);
                });
    }

    @Test
    void shouldReturnListOfGroupsWithSubjectsAverageMarks_WhenDefaultPageable() {
        ResponseEntity<GroupSubjectsDto[]> response = restTemplate.getForEntity("/groups/subjects", GroupSubjectsDto[].class);
        HttpHeaders headers = response.getHeaders();
        GroupSubjectsDto[] groups = response.getBody();

        assertTrue(headers.getContentType().includes(MediaType.APPLICATION_JSON));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(4, groups.length);
        Arrays.stream(groups)
                .forEach(g -> {
                    Set<SubjectAverageMarkDto> subjects = g.getSubjects();

                    assertInstanceOf(GroupSubjectsDto.class, g);
                    assertEquals(2, subjects.size());
                    subjects.stream()
                            .forEach(s -> {
                                assertInstanceOf(SubjectAverageMarkDto.class, s);
                                assertNotNull(s.getAverageMark());
                            });
                });
    }

    @Test
    void shouldReturnListOfGroupsWhereMalePrevailsOverFemale_WhenDefaultPageable() {
        ResponseEntity<GroupGendersCountDto[]> response = restTemplate.getForEntity("/groups/male-prevails-female", GroupGendersCountDto[].class);
        HttpHeaders headers = response.getHeaders();
        GroupGendersCountDto[] groups = response.getBody();

        assertTrue(headers.getContentType().includes(MediaType.APPLICATION_JSON));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(2, groups.length);
        Arrays.stream(groups)
                .forEach(g -> {
                    assertNotNull(g.getMaleCount());
                    assertNotNull(g.getFemaleCount());
                });
    }
}