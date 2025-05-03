
package com.elementary.mx.elementary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elementary.mx.elementary.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
    
}