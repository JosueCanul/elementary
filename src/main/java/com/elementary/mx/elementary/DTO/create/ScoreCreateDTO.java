package com.elementary.mx.elementary.DTO.create;

import java.sql.Date;

import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.model.Subject;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScoreCreateDTO{
    Integer scoreId;
    @NotNull
    Student student;
    @NotNull
    Subject subject;
    @NotNull
    int score;
    @NotNull
    Date startDate;
    @NotNull
    Date endDate;
}
