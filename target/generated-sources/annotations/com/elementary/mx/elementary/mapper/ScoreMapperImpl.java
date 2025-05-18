package com.elementary.mx.elementary.mapper;

import com.elementary.mx.elementary.DTO.create.ScoreCreateDTO;
import com.elementary.mx.elementary.model.Score;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-18T09:24:00-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ScoreMapperImpl implements ScoreMapper {

    @Override
    public void updateScoreFromRecord(ScoreCreateDTO dto, Score score) {
        if ( dto == null ) {
            return;
        }

        if ( dto.endDate() != null ) {
            score.setEndDate( dto.endDate() );
        }
        score.setScore( dto.score() );
        if ( dto.scoreId() != null ) {
            score.setScoreId( dto.scoreId() );
        }
        if ( dto.startDate() != null ) {
            score.setStartDate( dto.startDate() );
        }
        if ( dto.student() != null ) {
            score.setStudent( dto.student() );
        }
        if ( dto.subject() != null ) {
            score.setSubject( dto.subject() );
        }
    }
}
