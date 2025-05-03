package com.elementary.mx.elementary.DTO;

import com.elementary.mx.elementary.model.Grade;

public record SubjectDTO(
    String subjectName,
    String description,
    Grade grade
) 
{}
