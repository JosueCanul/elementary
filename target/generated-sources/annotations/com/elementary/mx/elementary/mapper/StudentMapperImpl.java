package com.elementary.mx.elementary.mapper;

import com.elementary.mx.elementary.DTO.StudentDTO;
import com.elementary.mx.elementary.model.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-03T15:46:03-0600",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public void updateStudentFromRecord(StudentDTO dto, Student student) {
        if ( dto == null ) {
            return;
        }

        if ( dto.email() != null ) {
            student.setEmail( dto.email() );
        }
        if ( dto.enrollment() != null ) {
            student.setEnrollment( dto.enrollment() );
        }
        if ( dto.grade() != null ) {
            student.setGrade( dto.grade() );
        }
        if ( dto.lastName() != null ) {
            student.setLastName( dto.lastName() );
        }
        if ( dto.name() != null ) {
            student.setName( dto.name() );
        }
    }
}
