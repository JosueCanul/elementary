package com.elementary.mx.elementary.DTO.body;

import com.elementary.mx.elementary.model.Grade;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentBodyDTO{
    @NotBlank
    @Size(min = 10, max = 10)
    String enrollment;
    @NotBlank
    @Size(min = 3, max = 20)
    String name;
    @NotBlank
    String lastName;
    @NotNull
    Grade grade;
    @NotBlank
    @Email
    String email;
}
