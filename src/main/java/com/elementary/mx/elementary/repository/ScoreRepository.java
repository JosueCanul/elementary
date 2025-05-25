package com.elementary.mx.elementary.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elementary.mx.elementary.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
    @Query(
        value = """
        SELECT COUNT(*) FROM score_table 
        WHERE id_student=?1 
        AND id_subject=?2 
        AND start_date=?3 
        AND end_date=?4
        """, nativeQuery = true )
    Long countInstance(
        Integer studentId, Integer subjectId, Date startDate, Date endDate
    );


}
