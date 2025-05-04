package com.elementary.mx.elementary.mapper;


import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.elementary.mx.elementary.DTO.ScoreDTO;
import com.elementary.mx.elementary.exception.IncompatibleGradeException;
import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.model.Subject;
import com.elementary.mx.elementary.service.StudentService;
import com.elementary.mx.elementary.service.SubjectService;

@Mapper(componentModel = "spring")
public class ScoreMapper {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    public void updateScoreFromRecord(ScoreDTO dto, Score score) throws IncompatibleGradeException{
        score.setEndDate(dto.endDate());
        score.setStartDate(dto.startDate());
        score.setScoreId(dto.scoreId());
        score.setScore(dto.score());
        Student student = this.studentService.findStudentById(dto.enrollment());
        Subject subject = this.subjectService.findSubjectById(dto.subjectName());
        if (student.getGrade() == subject.getGrade()) {
            score.setStudent(student);
            score.setSubject(subject);
        } else {
            throw new IncompatibleGradeException();
        }
    }

}
