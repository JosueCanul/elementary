package com.elementary.mx.elementary.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.elementary.mx.elementary.DTO.body.SubjectBodyDTO;
import com.elementary.mx.elementary.DTO.update.SubjectUpdateDTO;
import com.elementary.mx.elementary.model.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapSubjectFromBodyRecord(SubjectBodyDTO dto, @MappingTarget Subject subject);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapSubjectFromUpdateRecord(SubjectUpdateDTO dto, @MappingTarget Subject subject);

}

