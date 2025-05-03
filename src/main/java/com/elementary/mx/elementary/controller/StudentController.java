package com.elementary.mx.elementary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.model.DTO.CreateStudentDTO;
import com.elementary.mx.elementary.service.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> findAll(){
        return studentService.listStudents();
    }

    // @GetMapping("/perfíl/{id}")
    // public Student findStudent(@PathVariable String id){
    //     return studentService
    // }
    @PutMapping()
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
    
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id){
        studentService.deleteStudentById(id);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVehicle(@Valid @RequestBody CreateStudentDTO data){
        studentService.createStudent(data);
    }
}
