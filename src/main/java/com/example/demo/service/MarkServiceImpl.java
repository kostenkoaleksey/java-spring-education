package com.example.demo.service;

import com.example.demo.model.Mark;
import com.example.demo.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MarkServiceImpl implements MarkService {
    @Override
    public double getAverageMark(List<Mark> marks) {
        return marks
                .stream()
                .collect(Collectors.averagingDouble(Mark::getMark))
                .doubleValue();
    }

    @Override
    public Map<Subject, Double> getSubjectsAverageMarks(List<Mark> marks) {
        return marks
                .stream()
                .collect(Collectors.groupingBy(Mark::getSubject, Collectors.averagingDouble(Mark::getMark)));
    }
}
