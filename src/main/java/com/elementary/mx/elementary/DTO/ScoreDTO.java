package com.elementary.mx.elementary.DTO;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ScoreDTO(
    Integer scoreId,
    @NotBlank
    String enrollment,
    @NotBlank
    String subjectName,
    @NotNull
    int score,
    @NotNull
    Date startDate,
    @NotNull
    Date endDate) 
{}
