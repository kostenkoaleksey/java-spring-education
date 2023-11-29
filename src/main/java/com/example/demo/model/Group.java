package com.example.demo.model;

import com.example.demo.model.projection.SubjectAverageMark;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "groups")
@Getter
@Setter
@EqualsAndHashCode(of = {"title", "faculty"})
public class Group {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Set<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty faculty;

    public Set<SubjectAverageMark> getSubjectsAverageMark() {
        return students
                .stream()
                .map(Student::getMarks)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Mark::getSubject,
                        Collectors.averagingDouble(Mark::getMark)
                ))
                .entrySet()
                .stream()
                .map(i -> new SubjectAverageMark() {
                    @Override
                    public Subject getSubject() {
                        return i.getKey();
                    }

                    @Override
                    public Double getAverageMark() {
                        return i.getValue();
                    }
                })
                .collect(Collectors.toSet());
    }
}
