package com.elementary.mx.elementary.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.elementary.mx.elementary.DTO.body.StudentBodyDTO;
import com.elementary.mx.elementary.DTO.update.StudentUpdateDTO;
import com.elementary.mx.elementary.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapStudentFromBodyRecord(StudentBodyDTO dto, @MappingTarget Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapStudentFromUpdateRecord(StudentUpdateDTO dto, @MappingTarget Student student);
}
