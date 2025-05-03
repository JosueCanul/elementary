package com.elementary.mx.elementary.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_table")
public class Student {

    @Id
    @Column(name =  "enrollment", length = 10, nullable = false, columnDefinition = "CHAR(10)")
    @Size(min = 10, max = 10)    
    private String enrollment;

    @Column(name = "student_name", length = 50)
    private String name;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Email
    @Column(length = 255)
    private String email;

}
