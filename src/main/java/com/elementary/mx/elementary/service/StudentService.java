package com.elementary.mx.elementary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.DTO.StudentDTO;
import com.elementary.mx.elementary.mapper.StudentMapper;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private StudentMapper studentMapper;

    public Student findStudentById(String enrollment) throws EntityNotFoundException{
        return this.studentRepository
                .findById(enrollment)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Student createStudent(StudentDTO studentDTO){
        Student student = new Student();
        this.studentMapper.updateStudentFromRecord(studentDTO, student);
        return this.studentRepository.save(student);
    }

    public void deleteStudentById(String enrollment){
        this.studentRepository.deleteById(enrollment);
    }

    public Student updateStudent(StudentDTO studentDTO, String enrollment) throws EntityNotFoundException{

        Student studentToSave = this.studentRepository.findById(enrollment)
            .map(s -> {
                this.studentMapper.updateStudentFromRecord(studentDTO, s);
                return s;
            }).orElseThrow(EntityNotFoundException::new);
        return this.studentRepository.save(studentToSave);
    }

    public List<Student> findAllStudents(){
        return this.studentRepository.findAll();
    }
}
