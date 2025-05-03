package com.elementary.mx.elementary.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.elementary.mx.elementary.DTO.StudentDTO;
import com.elementary.mx.elementary.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromRecord(StudentDTO dto, @MappingTarget Student student);
}
