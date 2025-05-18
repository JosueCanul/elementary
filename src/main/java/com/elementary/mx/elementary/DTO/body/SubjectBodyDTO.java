package com.elementary.mx.elementary.DTO.body;

import com.elementary.mx.elementary.model.Grade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SubjectBodyDTO{
    @NotBlank
    @Size(min = 5, max = 150)
    String subjectName;
    @NotBlank
    @Size(max = 255)
    String description;
    @NotNull
    Grade grade;
 
}
