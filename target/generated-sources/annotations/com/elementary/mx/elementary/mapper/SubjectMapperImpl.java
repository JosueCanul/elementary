package com.elementary.mx.elementary.mapper;

import com.elementary.mx.elementary.DTO.SubjectDTO;
import com.elementary.mx.elementary.model.Subject;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-04T17:00:16-0600",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public void updateSubjectFromRecord(SubjectDTO dto, Subject student) {
        if ( dto == null ) {
            return;
        }

        if ( dto.description() != null ) {
            student.setDescription( dto.description() );
        }
        if ( dto.grade() != null ) {
            student.setGrade( dto.grade() );
        }
        if ( dto.subjectName() != null ) {
            student.setSubjectName( dto.subjectName() );
        }
    }
}
