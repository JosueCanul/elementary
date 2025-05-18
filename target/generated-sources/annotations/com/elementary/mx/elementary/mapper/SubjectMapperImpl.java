package com.elementary.mx.elementary.mapper;

import com.elementary.mx.elementary.DTO.body.SubjectBodyDTO;
import com.elementary.mx.elementary.DTO.update.SubjectUpdateDTO;
import com.elementary.mx.elementary.model.Subject;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-18T10:18:23-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public void mapSubjectFromBodyRecord(SubjectBodyDTO dto, Subject subject) {
        if ( dto == null ) {
            return;
        }

        if ( dto.description() != null ) {
            subject.setDescription( dto.description() );
        }
        if ( dto.grade() != null ) {
            subject.setGrade( dto.grade() );
        }
        if ( dto.subjectName() != null ) {
            subject.setSubjectName( dto.subjectName() );
        }
    }

    @Override
    public void mapSubjectFromUpdateRecord(SubjectUpdateDTO dto, Subject subject) {
        if ( dto == null ) {
            return;
        }

        if ( dto.description() != null ) {
            subject.setDescription( dto.description() );
        }
        if ( dto.grade() != null ) {
            subject.setGrade( dto.grade() );
        }
        if ( dto.subjectName() != null ) {
            subject.setSubjectName( dto.subjectName() );
        }
    }
}
