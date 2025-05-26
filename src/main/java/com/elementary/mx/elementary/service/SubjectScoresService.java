package com.elementary.mx.elementary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.model.Subject;
import com.elementary.mx.elementary.repository.ScoreRepository;
import com.elementary.mx.elementary.repository.SubjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubjectScoresService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private SubjectRepository subjectRepository;

     public Map<String, Object> getSubjectScore(String subjectName) throws EntityNotFoundException{
        Subject subject = subjectRepository.findBySubjectName(subjectName).orElseThrow(EntityNotFoundException::new);

        List<Score> scoresList = scoreRepository.findAllBySubject(subject);
        long averageGrade = this.calculateAverageGrade(scoresList);

        Map<String, Object> reportCard = new HashMap<>();
        reportCard.put("scoresList", scoresList);
        reportCard.put("averageGrade", averageGrade);
        return reportCard;
        

    }

    public long calculateAverageGrade(List<Score> scoresList){
        long averageGrade = 0;
        int numberOfGrades = 0;
        for (Score score : scoresList) {
            averageGrade =+ score.getScore();
            numberOfGrades =+ 1;
        }
        averageGrade = averageGrade / numberOfGrades;
        return averageGrade;

    }
}
