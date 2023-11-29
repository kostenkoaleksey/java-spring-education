package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.projection.StudentAverageMark;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeBetween(Integer startAge, Integer endAge, Pageable pageable);

    @Query("""
            SELECT s AS student, AVG(m.mark) AS averageMark
            FROM Student s
            JOIN Mark m ON m.student.id = s.id
            GROUP BY s.id
            HAVING AVG(m.mark) > :averageNum
            """)
    List<StudentAverageMark> findExcellentStudents(@Param("averageNum") Integer averageNum, Pageable pageable);

    @Query("""
            SELECT s FROM Student s
            JOIN Group g ON s.group.id = g.id
            WHERE g.faculty.id = :id
            """)
    List<Student> findStudentsByFacultyId(@Param("id") Long facultyId, Pageable pageable);
}
