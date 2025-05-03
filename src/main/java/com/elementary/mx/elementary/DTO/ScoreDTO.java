package com.elementary.mx.elementary.DTO;

import java.sql.Date;

import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.model.Subject;

import jakarta.validation.constraints.NotBlank;

public record ScoreDTO(
    @NotBlank
    Integer scoreId,
    @NotBlank
    Student student,
    @NotBlank
    Subject subject,
    @NotBlank
    int score,
    @NotBlank
    Date startDate,
    @NotBlank
    Date endDate) 
{}
