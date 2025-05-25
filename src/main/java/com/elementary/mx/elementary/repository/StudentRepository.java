
package com.elementary.mx.elementary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elementary.mx.elementary.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    Optional<Student> findByEnrollment(String enrollment);
    
    void deleteByEnrollment(String enrollment);
}