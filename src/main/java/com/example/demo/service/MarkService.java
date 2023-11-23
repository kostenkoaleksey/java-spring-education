package com.example.demo.service;

import com.example.demo.model.Mark;
import com.example.demo.model.Subject;

import java.util.List;
import java.util.Map;

public interface MarkService {
    double getAverageMark(List<Mark> marks);

    Map<Subject, Double> getSubjectsAverageMarks(List<Mark> marks);
}
