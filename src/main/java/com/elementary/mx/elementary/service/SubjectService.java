package com.elementary.mx.elementary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.DTO.body.SubjectBodyDTO;
import com.elementary.mx.elementary.DTO.update.SubjectUpdateDTO;
import com.elementary.mx.elementary.model.Subject;
import com.elementary.mx.elementary.repository.SubjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    
    public Subject createSubject(SubjectBodyDTO subjectDTO){
        Subject subject = createSubjectFromDTO(subjectDTO);
        return this.subjectRepository.save(subject);
    }

    public Subject findSubjectById(String id) throws EntityNotFoundException{
        return this.subjectRepository
                        .findBySubjectName(id)
                        .orElseThrow(EntityNotFoundException::new);
    }
    
    public List<Subject> findAllSubjects(){
        return this.subjectRepository.findAll();
    }

    public Subject updateSubject(SubjectUpdateDTO subjectDTO, String id) throws EntityNotFoundException{
        Subject subjectTosave = findSubjectById(id);
        updateSubjectFromDTO(subjectTosave, subjectDTO);
        return this.subjectRepository.save(subjectTosave);
    }

    public void deleteSubjectBySubjectName(String subjectName) {
        this.subjectRepository.deleteBySubjectName(subjectName);
    }

    private Subject createSubjectFromDTO(SubjectBodyDTO subjectDTO){
        return new Subject(
            subjectDTO.getSubjectName(), 
            subjectDTO.getDescription(), 
            subjectDTO.getGrade());
    }
    private void updateSubjectFromDTO(Subject subject, SubjectUpdateDTO dto){
        subject.setDescription(dto.getDescription());
        subject.setGrade(dto.getGrade());
    }
}
