package com.elementary.mx.elementary.DTO.update;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record ScoreUpdateDTO(
    Integer scoreId,
    @Size(min = 10, max = 10)
    String enrollment,
    @Size(min = 5, max = 150)
    String subjectName,
    @Min(0)
    @Max(100)
    int score,
    Date startDate,
    Date endDate) 
{}
