package com.elementary.mx.elementary.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.mx.elementary.model.IrregularStudent;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.service.StudentScoresService;
import com.elementary.mx.elementary.service.StudentsListService;
import com.elementary.mx.elementary.service.SubjectScoresService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins ="*")
public class ReportsController {

    @Autowired
    private StudentScoresService studentScoresService;
    @Autowired
    private SubjectScoresService subjectScoresService;
    @Autowired
    private StudentsListService studentsListService;


    @GetMapping("/student/{enrollment}")
    public ResponseEntity<Map<String, Object>> getStudentsScores(@PathVariable String enrollment ) throws EntityNotFoundException{
        Map<String, Object> reportCard = studentScoresService.getStudentsScore(enrollment);
        return new ResponseEntity<Map<String, Object>>(reportCard,HttpStatus.OK);
    }

    @GetMapping("/subject/{subjectName}")
    public ResponseEntity<Map<String, Object>> getSubjectScores(@PathVariable String subjectName ) throws EntityNotFoundException{
        Map<String, Object> reportCard = subjectScoresService.getSubjectScore(subjectName);
        return new ResponseEntity<Map<String,Object>>(reportCard, HttpStatus.OK);
    }

    @GetMapping("/regular")
    public ResponseEntity<List<Student>> getRegularStudents() throws EntityNotFoundException{
        List<Student> studentsList = studentsListService.getRegularStudents();
        return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);
    }

    @GetMapping("/irregular")
    public  ResponseEntity<Map<String, List<IrregularStudent>>> getIrregularStudents( ) throws EntityNotFoundException{
         Map<String, List<IrregularStudent>> irregularStudentsReport = studentsListService.getIrregularStudents();
        return new ResponseEntity<Map<String, List<IrregularStudent>>>(irregularStudentsReport, HttpStatus.OK);
    }


}
