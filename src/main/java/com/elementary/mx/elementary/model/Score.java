package com.elementary.mx.elementary.model;

import java.sql.Date;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "score_table")
public class Score {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer scoreId;

    @ManyToOne
    @JoinColumn(name = "enrollment", columnDefinition = "CHAR(10)")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "subject_name")
    private Subject subject;

    @Column(name = "score")
    private int score;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "final_date")
    @Temporal(TemporalType.DATE)
    private Date enDate;
}
