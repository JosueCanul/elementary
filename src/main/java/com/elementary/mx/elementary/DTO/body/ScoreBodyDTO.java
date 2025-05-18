package com.elementary.mx.elementary.DTO.body;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class ScoreBodyDTO{
    @NotBlank
    @Size(min = 10, max = 10)
    String enrollment;
    @NotBlank
    @Size(min = 5, max = 150)
    String subjectName;
    @NotNull
    @Min(0)
    @Max(100)
    int score;
    @NotNull
    Date startDate;
    @NotNull
    Date endDate;
}
