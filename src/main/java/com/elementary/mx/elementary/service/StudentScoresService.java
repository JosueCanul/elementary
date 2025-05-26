package com.elementary.mx.elementary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.repository.ScoreRepository;
import com.elementary.mx.elementary.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentScoresService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Map<String, Object> getStudentsScore(String enrrollment) throws EntityNotFoundException{
        Student student = studentRepository.findByEnrollment(enrrollment).orElseThrow(EntityNotFoundException::new);

        List<Score> scoresList = scoreRepository.findAllByStudent(student);
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
            averageGrade += score.getScore();
            numberOfGrades += 1;
        }
        averageGrade = averageGrade / numberOfGrades;
        return averageGrade;

    }

}
