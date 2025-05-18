package com.elementary.mx.elementary.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.elementary.mx.elementary.DTO.create.ScoreCreateDTO;
import com.elementary.mx.elementary.model.Score;

@Mapper(componentModel = "spring")
public interface ScoreMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateScoreFromRecord(ScoreCreateDTO dto, @MappingTarget Score score);
}
