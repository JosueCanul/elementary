package com.elementary.mx.elementary.DTO.update;

import com.elementary.mx.elementary.model.Grade;

import jakarta.validation.constraints.Size;

public record SubjectUpdateDTO(
    @Size(min = 5, max = 150)
    String subjectName,
    @Size(max = 255)
    String description,
    Grade grade
) 
{}
