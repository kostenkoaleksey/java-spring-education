package com.example.demo.exception;

import lombok.Value;

@Value
public class ExceptionResponse {
    int status;
    String message;
}
