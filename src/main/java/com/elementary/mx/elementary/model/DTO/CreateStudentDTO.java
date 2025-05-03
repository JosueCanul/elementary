package com.elementary.mx.elementary.model.DTO;

import com.elementary.mx.elementary.model.Grade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateStudentDTO (
    @NotBlank
    String enrollment,
    @NotBlank
    @Size(max = 30, min = 3)
    String name,
    @NotBlank
    String last_name,
    @NotBlank
    Grade grade)
{}
