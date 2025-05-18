package com.elementary.mx.elementary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.DTO.body.ScoreBodyDTO;
import com.elementary.mx.elementary.DTO.create.ScoreCreateDTO;
import com.elementary.mx.elementary.DTO.update.ScoreUpdateDTO;
import com.elementary.mx.elementary.exception.IncompatibleGradeException;
import com.elementary.mx.elementary.mapper.ScoreMapper;
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
    private ScoreMapper scoreMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    public Score createScore(ScoreBodyDTO scoreDTO){
        Student student = this.studentService.findStudentById(scoreDTO.enrollment());
        Subject subject = this.subjectService.findSubjectById(scoreDTO.subjectName());
        
        if (!student.getGrade().equals(subject.getGrade())) {
            throw new IncompatibleGradeException();
        }
            
        ScoreCreateDTO scoreCreateDTO = new ScoreCreateDTO(null, 
                                                            student, 
                                                            subject, 
                                                            scoreDTO.score(), 
                                                            scoreDTO.startDate(), 
                                                            scoreDTO.endDate());
        Score score = new Score();
        this.scoreMapper.updateScoreFromRecord(scoreCreateDTO, score);
        return this.scoreRepository.save(score);
    }

    public Score findScoreById(int id) throws EntityNotFoundException{
        return this.scoreRepository
                        .findById(id)
                        .orElseThrow(EntityNotFoundException::new);
    }

    public List<Score> findAll(){
        return this.scoreRepository.findAll();
    }

    public Score updateScore(int id, ScoreUpdateDTO scoreDTO){
        Student student = this.studentService.findStudentById(scoreDTO.enrollment());
        Subject subject = this.subjectService.findSubjectById(scoreDTO.subjectName());
        Score score = this.findScoreById(id);
        ScoreCreateDTO scoreCreateDTO = new ScoreCreateDTO(null, 
                                                            student, 
                                                            subject, 
                                                            scoreDTO.score(), 
                                                            scoreDTO.startDate(), 
                                                            scoreDTO.endDate());
        this.scoreMapper.updateScoreFromRecord(scoreCreateDTO, score);
        return this.scoreRepository.save(score);
    }

    public void deleteScoreById(int id){
        this.scoreRepository.deleteById(id);
    }
}
