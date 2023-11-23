package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "faculties")
@Getter
@Setter
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "faculty")
    private Set<Group> groups;
}
