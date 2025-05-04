package com.elementary.mx.elementary.DTO;

import com.elementary.mx.elementary.model.Grade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SubjectDTO(
    @NotBlank
    String subjectName,
    @NotBlank
    @Size(max = 255)
    String description,
    @NotNull
    Grade grade
) 
{}
