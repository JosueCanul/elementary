package com.elementary.mx.elementary.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "subject_table")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "subject_name", unique = true)
    private String subjectName;
    
    @Column(name = "description", length = 200)
    private String description;
    
    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Subject(String subjectName, String description, Grade grade) {
        this.subjectName = subjectName;
        this.description = description;
        this.grade = grade;
    }

    
}
