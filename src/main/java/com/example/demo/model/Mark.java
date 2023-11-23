package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marks")
@Getter
@Setter
public class Mark {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer mark;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;
}
