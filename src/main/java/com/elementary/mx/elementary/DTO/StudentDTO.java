package com.elementary.mx.elementary.DTO;

import com.elementary.mx.elementary.model.Grade;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentDTO(
    @NotBlank
    String enrollment,
    @NotBlank
    @Size(max = 30, min = 3)
    String name,
    @NotBlank
    String lastName,
    @NotBlank
    Grade grade,
    @NotBlank
    @Email
    String email)
{}
