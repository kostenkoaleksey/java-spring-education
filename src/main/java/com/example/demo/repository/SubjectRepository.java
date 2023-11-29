package com.example.demo.repository;

import com.example.demo.model.Subject;
import com.example.demo.model.projection.SubjectAverageMark;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("""
            SELECT s AS subject, AVG(m.mark) AS averageMark
            FROM Subject s
            JOIN Mark m ON m.subject = s
            GROUP BY s.id
            """)
    List<SubjectAverageMark> findSubjectsAverageMark(Pageable pageable);
}
