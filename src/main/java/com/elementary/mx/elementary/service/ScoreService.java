package com.elementary.mx.elementary.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.DTO.body.ScoreBodyDTO;
import com.elementary.mx.elementary.DTO.record.MatchScore;
import com.elementary.mx.elementary.DTO.update.ScoreUpdateDTO;
import com.elementary.mx.elementary.exception.DuplicatedScoreRecordException;
import com.elementary.mx.elementary.exception.IncompatibleGradeException;
import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.model.Subject;
import com.elementary.mx.elementary.repository.ScoreRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    public Score createScore(ScoreBodyDTO scoreDTO) throws IncompatibleGradeException, DuplicatedScoreRecordException{
        Student student = this.studentService.findStudentByEnrollment(scoreDTO.getEnrollment());
        Subject subject = this.subjectService.findSubjectById(scoreDTO.getSubjectName());
        MatchScore matchScore = new MatchScore(
            student.getId(),
            subject.getId(),
            scoreDTO.getStartDate(),
            scoreDTO.getEndDate()
        );
        validateGradeRule(student, subject);
        validateUniqueScoreRule(matchScore);
        
        Score score = new Score(
            scoreDTO.getScore(), 
            scoreDTO.getStartDate(), 
            scoreDTO.getEndDate());
        score.setStudent(student);
        score.setSubject(subject);
        return this.scoreRepository.save(score);
    }

    public Score findScoreById(int id) throws EntityNotFoundException{
        return this.scoreRepository
                        .findById(id)
                        .orElseThrow(EntityNotFoundException::new);
    }

    public List<Map<String, Object>> findAll(){
        return this.scoreRepository.findAllSimplified();
    }

    public Score updateScore(int id, ScoreUpdateDTO scoreDTO) throws DuplicatedScoreRecordException{
        Student student = this.studentService.findStudentByEnrollment(scoreDTO.getEnrollment());
        Subject subject = this.subjectService.findSubjectById(scoreDTO.getSubjectName());
        
        Score score = this.findScoreById(id);
        
        MatchScore matchScore = new MatchScore(
            student.getId(),
            subject.getId(),
            scoreDTO.getStartDate(),
            scoreDTO.getEndDate()
        );
        validateUniqueScoreRule(matchScore);
        
        score.setScore(scoreDTO.getScore());
        score.setEndDate(scoreDTO.getEndDate());
        score.setStartDate(scoreDTO.getStartDate());
        score.setStudent(student);
        score.setSubject(subject);
        return this.scoreRepository.save(score);
    }

    public void deleteScoreById(int id){
        this.scoreRepository.deleteById(id);
    }

    private void validateGradeRule(Student student, Subject subject){
        if (!student.getGrade().equals(subject.getGrade())) {
            throw new IncompatibleGradeException();
        }
    }

    private void validateUniqueScoreRule(MatchScore matchScore) throws DuplicatedScoreRecordException{
        Long instanceScore  = this.scoreRepository.countInstance(
            matchScore.studentId(), matchScore.subjectId(), matchScore.startDate(), matchScore.endDate());
        if (instanceScore > 0) {
            throw new DuplicatedScoreRecordException();
        }
    }
}
