package com.elementary.mx.elementary.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.elementary.mx.elementary.DTO.SubjectDTO;
import com.elementary.mx.elementary.model.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSubjectFromRecord(SubjectDTO dto, @MappingTarget Subject student);
}


