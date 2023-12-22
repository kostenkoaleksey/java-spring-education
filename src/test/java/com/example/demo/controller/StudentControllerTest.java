package com.example.demo.controller;

import com.example.demo.BaseTestcontainers;
import com.example.demo.dto.ExcellentStudentDto;
import com.example.demo.dto.StudentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class StudentControllerTest extends BaseTestcontainers {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnListOfStudents_WhenTreeHundredRecordsPerPage() {
        int pageSize = 300;
        ResponseEntity<StudentDto[]> response = restTemplate.getForEntity("/students?size={pageSize}", StudentDto[].class, pageSize);
        StudentDto[] students = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(200, students.length);
        Arrays.stream(students)
                .forEach(s -> {
                    assertInstanceOf(StudentDto.class, s);
                });
    }

    @Test
    void shouldReturnListOfStudentsOfDraftArmyAge_WhenDefaultPageable() {
        ResponseEntity<StudentDto[]> response = restTemplate.getForEntity("/students/draft-army-age", StudentDto[].class);
        StudentDto[] students = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(students.length);
        Arrays.stream(students)
                .forEach(s -> {
                    assertInstanceOf(StudentDto.class, s);
                });
    }

    @Test
    void shouldReturnListOfExcellentStudents_WhenDefaultPageable() {
        ResponseEntity<ExcellentStudentDto[]> response = restTemplate.getForEntity("/students/excellent-students", ExcellentStudentDto[].class);
        ExcellentStudentDto[] students = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(students.length);
        Arrays.stream(students)
                .forEach(s -> {
                    assertInstanceOf(ExcellentStudentDto.class, s);
                });
    }
}