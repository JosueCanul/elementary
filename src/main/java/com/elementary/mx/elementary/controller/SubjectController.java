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

import com.elementary.mx.elementary.DTO.SubjectDTO;
import com.elementary.mx.elementary.model.Subject;
import com.elementary.mx.elementary.service.SubjectService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody SubjectDTO subjectDTO){
        Subject subject = this.subjectService.createSubject(subjectDTO);
        return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable String id) throws EntityNotFoundException{
        Subject subject = this.subjectService.findSubjectById(id);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Subject>> findAllSubjects(){
        List<Subject> subjects = this.subjectService.findAllSubjects();
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject (@Valid @RequestBody SubjectDTO subjectDTO, @PathVariable String id){
        Subject subject = this.subjectService.updateSubject(subjectDTO, id);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSubjectById(@PathVariable String id) throws EntityNotFoundException{
        this.subjectService.deleteSubjectById(id);
    }
}
