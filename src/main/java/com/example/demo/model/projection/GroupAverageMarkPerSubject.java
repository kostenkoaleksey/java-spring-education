package com.example.demo.model.projection;

import java.util.Set;

public interface GroupAverageMarkPerSubject {
    Long getId();

    String getTitle();

    Set<SubjectAverageMark> getSubjectsAverageMark();
}
