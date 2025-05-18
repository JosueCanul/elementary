package com.elementary.mx.elementary.DTO.update;

import com.elementary.mx.elementary.model.Grade;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record StudentUpdateDTO(
    @Size(min = 10, max = 10)
    String enrollment,
    @Size(min = 3, max = 20)
    String name,
    @Size(min = 3, max = 20)
    String lastName,
    Grade grade,
    @Email
    String email)
{}
