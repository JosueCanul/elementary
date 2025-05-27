package com.elementary.mx.elementary.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.model.Subject;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
    @Query(value = """
            SELECT COUNT(*) FROM score_table
            WHERE id_student=?1
            AND id_subject=?2
            AND start_date=?3
            AND end_date=?4
            """, nativeQuery = true)
    Long countInstance(
            Integer studentId, Integer subjectId, LocalDate startDate, LocalDate endDate);



    @Query(
        value = """
                SELECT 
                score_table.id AS scoreId,
                enrollment,
                start_date AS startDate,
                end_date AS endDate, 
                score AS score,
                subject_name AS subjectName
                FROM student_table 
                JOIN score_table ON student_table.id = score_table.id_student
                JOIN subject_table ON score_table.id_subject = subject_table.id
                """,
        nativeQuery = true
    )
    List<Map<String, Object>> findAllSimplified();
    List<Score> findAllByStudent(Student student);
    List<Score> findAllBySubject(Subject subject);

    List<Score> findByScoreGreaterThan(int score);
    List<Score> findByScoreLessThan(int score);
}
