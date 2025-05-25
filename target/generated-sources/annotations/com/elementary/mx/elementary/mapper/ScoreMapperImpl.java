package com.elementary.mx.elementary.mapper;

import com.elementary.mx.elementary.DTO.create.ScoreCreateDTO;
import com.elementary.mx.elementary.model.Score;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-24T20:57:24-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ScoreMapperImpl implements ScoreMapper {

    @Override
    public void updateScoreFromRecord(ScoreCreateDTO dto, Score score) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getEndDate() != null ) {
            score.setEndDate( dto.getEndDate() );
        }
        score.setScore( dto.getScore() );
        if ( dto.getScoreId() != null ) {
            score.setScoreId( dto.getScoreId() );
        }
        if ( dto.getStartDate() != null ) {
            score.setStartDate( dto.getStartDate() );
        }
        if ( dto.getStudent() != null ) {
            score.setStudent( dto.getStudent() );
        }
        if ( dto.getSubject() != null ) {
            score.setSubject( dto.getSubject() );
        }
    }
}
