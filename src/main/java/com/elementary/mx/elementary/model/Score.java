package com.elementary.mx.elementary.model;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table( name = "score_table",
        uniqueConstraints = @UniqueConstraint( 
                                                name="score_unique", 
                                                columnNames = { "id_student", 
                                                                "id_subject", 
                                                                "start_date", 
                                                                "end_date"}))
public class Score {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer scoreId;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @Column(name = "score")
    private int score;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    public Score(int score, LocalDate startDate, LocalDate endDate) {
        this.score = score;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    
}
