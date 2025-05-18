package com.elementary.mx.elementary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.DTO.body.StudentBodyDTO;
import com.elementary.mx.elementary.DTO.update.StudentUpdateDTO;
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

    public Student createStudent(StudentBodyDTO studentDTO){
        Student student = new Student();
        this.studentMapper.mapStudentFromBodyRecord(studentDTO, student);
        System.out.println(student.toString());
        return this.studentRepository.save(student);
    }

    public Student findStudentById(String id) throws EntityNotFoundException{
        return this.studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
    
    public List<Student> findAllStudents(){
        return this.studentRepository.findAll();
    }

    public Student updateStudent(String id, StudentUpdateDTO studentDTO) throws EntityNotFoundException{
        Student studentToSave = findStudentById(id);
        this.studentMapper.mapStudentFromUpdateRecord(studentDTO, studentToSave);
        return this.studentRepository.save(studentToSave);
    }

    public void deleteStudentById(String enrollment){
        this.studentRepository.deleteById(enrollment);
    }




}
