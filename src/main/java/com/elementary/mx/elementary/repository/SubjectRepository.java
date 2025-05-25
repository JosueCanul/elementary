package com.elementary.mx.elementary.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.elementary.mx.elementary.model.Grade;
import com.elementary.mx.elementary.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
    List<Subject> findByGrade(Grade grade);
    
    Optional<Subject> findBySubjectName(String subjectName);

    void deleteBySubjectName(String subjectName);

    @Query(value="""
            SELECT subject_name FROM subject_table
            """, nativeQuery=true)
    List<String> findAllSubjectsNames();
}
