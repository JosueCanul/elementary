package com.elementary.mx.elementary.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.mx.elementary.DTO.StudentDTO;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.service.StudentService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable String id){
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> students = this.studentService.findAllStudents();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentDTO studentDTO, @PathVariable String id) {
        Student student = studentService.updateStudent(studentDTO, id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudentById(@PathVariable String id){
        studentService.deleteStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO data){
        Student student = studentService.createStudent(data);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }
}
