package com.example.demo.repository;

import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.model.projection.GroupAverageMark;
import com.example.demo.model.projection.GroupAverageMarkPerSubject;
import com.example.demo.model.projection.GroupGenderCount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("""
            SELECT g AS group, AVG(m.mark) AS averageMark
            FROM Group g
            LEFT JOIN Student s ON s.group.id = g.id
            LEFT JOIN Mark m ON m.student.id = s.id
            GROUP BY g.id
            """)
    List<GroupAverageMark> findGroupsWithAverageMark(Pageable pageable);

    @Query("""
            SELECT g
            FROM Group g
            JOIN FETCH g.students
            JOIN FETCH g.students.marks
            JOIN FETCH g.students.marks.subject
            """)
    List<GroupAverageMarkPerSubject> findGroupsSubjectsWithAverageMark(Pageable pageable);

    @Query(value = """
            SELECT id, title, maleCount, femaleCount
            FROM (
                SELECT
                    g.id AS id,
                    g.title AS title,
                    SUM(CASE WHEN s.sex = :#{#gender1.name} then 1 else 0 end) AS maleCount,
                    SUM(CASE WHEN s.sex = :#{#gender2.name} then 1 else 0 end) AS femaleCount
                FROM groups g
                JOIN students s ON s.group_id = g.id
                GROUP BY g.id
            ) r
            WHERE maleCount > femaleCount
            """,
            nativeQuery = true)
    List<GroupGenderCount> findGroupStudentsGenderPrevailing(
            @Param("gender1") Student.Sex gender1,
            @Param("gender2") Student.Sex gender2,
            Pageable pageable
    );
}
