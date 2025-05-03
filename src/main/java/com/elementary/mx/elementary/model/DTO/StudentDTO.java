package com.elementary.mx.elementary.model.DTO;

import com.elementary.mx.elementary.model.Grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private String enrollment; 
    private String name; 
    private String last_name;
    private Grade grade;
}
