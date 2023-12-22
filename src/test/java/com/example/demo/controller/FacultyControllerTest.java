package com.example.demo.controller;

import com.example.demo.BaseTestcontainers;
import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.exception.ExceptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FacultyControllerTest extends BaseTestcontainers {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnListOfAllFaculties_WhenDefaultPageable() {
        ResponseEntity<FacultyDto[]> response = restTemplate.getForEntity("/faculties", FacultyDto[].class);
        FacultyDto[] list = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(2, list.length);
        assertTrue(Arrays.stream(list).allMatch(f -> f instanceof FacultyDto));
    }

    @Test
    void shouldReturnFacultyById() {
        ResponseEntity<FacultyDto> response = restTemplate.getForEntity("/faculties/1", FacultyDto.class);
        FacultyDto faculty = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(faculty);
        assertEquals(faculty.getId(), 1);
    }

    @Test
    void shouldReturnNotFoundException_WhenWrongFacultyIdGiven() {
        ExceptionResponse response = restTemplate.getForObject("/faculties/3", ExceptionResponse.class);

        assertInstanceOf(ExceptionResponse.class, response);
        assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());
    }

    @Test
    void shouldReturnListStudentsForSpecificFaculty_WhenDefaultPageable() {
        ResponseEntity<StudentDto[]> response = restTemplate.getForEntity("/faculties/1/students", StudentDto[].class);
        StudentDto[] students = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(10, students.length);
        assertTrue(Arrays.stream(students).allMatch(s -> s instanceof StudentDto));
    }

    @Test
    void shouldReturnNotFoundException_WhenRequestedListStudentsWithWrongFacultyId() {
        ExceptionResponse response = restTemplate.getForObject("/faculties/3/students", ExceptionResponse.class);

        assertInstanceOf(ExceptionResponse.class, response);
        assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());
    }
}