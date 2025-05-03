package com.elementary.mx.elementary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elementary.mx.elementary.model.Grade;
import com.elementary.mx.elementary.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String>{
    List<Subject> findByGrade(Grade grade);
}
