package com.elementary.mx.elementary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.model.IrregularStudent;
import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.repository.ScoreRepository;
import com.elementary.mx.elementary.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentsListService {

    private int APPROVED_SCORE = 70;
    
    @Autowired
    ScoreRepository scoreRepository;
    
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getRegularStudents(){
            List<Score> badScores = scoreRepository.findByScoreLessThan(APPROVED_SCORE);
            Set<String> enrollmentsWithFails = badScores.stream()
                .map(score -> score.getStudent().getEnrollment())
                .collect(Collectors.toSet());

            List<Student> allStudents = studentRepository.findAll();

            List<Student> regularStudents = allStudents.stream()
                .filter(student -> !enrollmentsWithFails.contains(student.getEnrollment()))
                .collect(Collectors.toList());

            return regularStudents;
        }

    

    public  Map<String, List<IrregularStudent>> getIrregularStudents(){
        List<Score> badScores = scoreRepository.findByScoreLessThan(APPROVED_SCORE);

        List<Student> studentsList = extractIrregularStudents(badScores);
        Map<String, Integer> numberOfFailedSubjects = countFailedSubjects(badScores);
        Map<String, List<IrregularStudent>> irregularStudentsReport = groupIrregularStudentsByGrade(studentsList, numberOfFailedSubjects);

        return irregularStudentsReport;
        
        }

        private List<Student> extractIrregularStudents(List<Score> badScores) {
            List<Student> studentsList = new ArrayList<>();
            Set<String> enrollments = new HashSet<>();

            for (Score score : badScores) {
                Student student = score.getStudent();
                String enrollment = student.getEnrollment();
                if (!enrollments.contains(enrollment)) {
                    studentsList.add(student);
                    enrollments.add(enrollment);
                }
            }

            return studentsList;
        }   

        
        private Map<String, Integer> countFailedSubjects(List<Score> badScores) {
            Map<String, Integer> numberOfFailedSubjects = new HashMap<>();

            for (Score score : badScores) {
                String enrollment = score.getStudent().getEnrollment();
                int currentCount = numberOfFailedSubjects.getOrDefault(enrollment, 0);
                numberOfFailedSubjects.put(enrollment, currentCount + 1);
            }

            return numberOfFailedSubjects; 
        }

        private Map<String, List<IrregularStudent>> groupIrregularStudentsByGrade(
                List<Student> studentsList,
                Map<String, Integer> numberOfFailedSubjects) {

            Map<String, List<IrregularStudent>> irregularStudentsReport = new HashMap<>();

            for (Student student : studentsList) {
                String enrollment = student.getEnrollment();
                String grade = student.getGrade().toString();

                irregularStudentsReport.putIfAbsent(grade, new ArrayList<>());

                List<IrregularStudent> studentsInGrade = irregularStudentsReport.get(grade);

                studentsInGrade.add(new IrregularStudent(
                    enrollment,
                    student.getName(),
                    numberOfFailedSubjects.get(enrollment)
                ));
            }

            return irregularStudentsReport; 
        }



    }
