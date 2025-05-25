package com.elementary.mx.elementary.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.mx.elementary.DTO.body.StudentBodyDTO;
import com.elementary.mx.elementary.DTO.update.StudentUpdateDTO;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.service.StudentService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;



@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentBodyDTO data) {
        Student student = studentService.createStudent(data);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @GetMapping("/{enrollment}")
    public ResponseEntity<Student> findStudentById(@PathVariable String enrollment) throws EntityNotFoundException{
        Student student = studentService.findStudentByEnrollment(enrollment);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = this.studentService.findAllStudents();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @PutMapping("/{enrollment}")
    public ResponseEntity<Student> updateStudent(@PathVariable String enrollment, @Valid @RequestBody StudentUpdateDTO studentDTO) throws EntityNotFoundException{
        Student student = studentService.updateStudent(enrollment, studentDTO);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable String id) throws EntityNotFoundException{
        studentService.deleteStudentById(id);
    }

}
