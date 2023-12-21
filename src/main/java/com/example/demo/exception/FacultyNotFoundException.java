package com.example.demo.exception;

import jakarta.persistence.EntityNotFoundException;

public class FacultyNotFoundException extends EntityNotFoundException {
    public FacultyNotFoundException(String message) {
        super(message);
    }
}
