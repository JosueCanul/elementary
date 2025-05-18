package com.elementary.mx.elementary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.DTO.body.SubjectBodyDTO;
import com.elementary.mx.elementary.DTO.update.SubjectUpdateDTO;
import com.elementary.mx.elementary.mapper.SubjectMapper;
import com.elementary.mx.elementary.model.Subject;
import com.elementary.mx.elementary.repository.SubjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;
    
    public Subject createSubject(SubjectBodyDTO subjectDTO){
        Subject subject = new Subject();
        this.subjectMapper.mapSubjectFromBodyRecord(subjectDTO, subject);
        return this.subjectRepository.save(subject);
    }

    public Subject findSubjectById(String id) throws EntityNotFoundException{
        return this.subjectRepository
                        .findById(id)
                        .orElseThrow(EntityNotFoundException::new);
    }
    
    public List<Subject> findAllSubjects(){
        return this.subjectRepository.findAll();
    }

    public Subject updateSubject(SubjectUpdateDTO subjectDTO, String id) throws EntityNotFoundException{
        Subject subjectTosave = findSubjectById(id);
        this.subjectMapper.mapSubjectFromUpdateRecord(subjectDTO, subjectTosave);
        return this.subjectRepository.save(subjectTosave);
    }

    public void deleteSubjectById(String id) {
        this.subjectRepository.deleteById(id);
    }

    
}
