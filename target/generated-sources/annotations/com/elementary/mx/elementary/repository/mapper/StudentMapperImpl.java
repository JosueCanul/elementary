package com.elementary.mx.elementary.repository.mapper;

import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-03T11:15:32-0600",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public void updateStudentFromRecord(Student student, Student studentToMap) {
        if ( student == null ) {
            return;
        }

        if ( student.getEnrolment() != null ) {
            studentToMap.setEnrolment( student.getEnrolment() );
        }
        if ( student.getGrade() != null ) {
            studentToMap.setGrade( student.getGrade() );
        }
        if ( student.getLastName() != null ) {
            studentToMap.setLastName( student.getLastName() );
        }
        if ( student.getName() != null ) {
            studentToMap.setName( student.getName() );
        }
        if ( studentToMap.getScores() != null ) {
            List<Score> list = student.getScores();
            if ( list != null ) {
                studentToMap.getScores().clear();
                studentToMap.getScores().addAll( list );
            }
        }
        else {
            List<Score> list = student.getScores();
            if ( list != null ) {
                studentToMap.setScores( new ArrayList<Score>( list ) );
            }
        }
    }
}
