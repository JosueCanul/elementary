package com.elementary.mx.elementary.mapper;

import com.elementary.mx.elementary.DTO.body.StudentBodyDTO;
import com.elementary.mx.elementary.DTO.update.StudentUpdateDTO;
import com.elementary.mx.elementary.model.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-18T10:17:53-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public void mapStudentFromBodyRecord(StudentBodyDTO dto, Student student) {
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

    @Override
    public void mapStudentFromUpdateRecord(StudentUpdateDTO dto, Student student) {
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
