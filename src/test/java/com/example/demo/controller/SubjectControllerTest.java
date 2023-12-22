package com.example.demo.controller;

import com.example.demo.BaseTestcontainers;
import com.example.demo.dto.SubjectAverageMarkDto;
import com.example.demo.dto.SubjectDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SubjectControllerTest extends BaseTestcontainers {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnListOfSubjects_WhenDefaultPageable() {
        ResponseEntity<SubjectDto[]> response = restTemplate.getForEntity("/subjects", SubjectDto[].class);
        SubjectDto[] subjects = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(2, subjects.length);
        Arrays.stream(subjects)
                .forEach(s -> {
                    assertInstanceOf(SubjectDto.class, s);
                });
    }

    @Test
    void shouldReturnListOfSubjectsWithAverageMarks_WhenDefaultPageable() {
        ResponseEntity<SubjectAverageMarkDto[]> response = restTemplate.getForEntity("/subjects/average-marks", SubjectAverageMarkDto[].class);
        SubjectAverageMarkDto[] subjects = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(2, subjects.length);
        Arrays.stream(subjects)
                .forEach(s -> {
                    assertNotNull(s.getAverageMark());
                    assertInstanceOf(SubjectAverageMarkDto.class, s);
                });
    }
}