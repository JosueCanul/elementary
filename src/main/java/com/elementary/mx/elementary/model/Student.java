package com.elementary.mx.elementary.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name =  "enrollment", unique = true, length = 10, nullable = false, columnDefinition = "CHAR(10)")
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

    public Student(@Size(min = 10, max = 10) String enrollment, String name, String lastName, Grade grade,
            @Email String email) {
        this.enrollment = enrollment;
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
        this.email = email;
    }


    
}
