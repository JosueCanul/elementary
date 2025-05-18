package com.elementary.mx.elementary.DTO.update;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreUpdateDTO{
    private Integer scoreId;
    @Size(min = 10, max = 10)
    private String enrollment;
    @Size(min = 5, max = 150)
    private String subjectName;
    @Min(0)
    @Max(100)
    private int score;
    private  Date startDate;
    private Date endDate; 
}
