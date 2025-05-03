package com.elementary.mx.elementary.repository.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.elementary.mx.elementary.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromRecord(Student student, @MappingTarget Student studentToMap);
}
