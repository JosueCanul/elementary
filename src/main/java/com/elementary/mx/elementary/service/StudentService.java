package com.elementary.mx.elementary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elementary.mx.elementary.DTO.body.StudentBodyDTO;
import com.elementary.mx.elementary.DTO.update.StudentUpdateDTO;
import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    public Student createStudent(StudentBodyDTO studentDTO){
        Student student = createStudentFromDTO(studentDTO);
        return this.studentRepository.save(student);
    }

    public Student findStudentByEnrollment(String enrollment) throws EntityNotFoundException{
        return this.studentRepository
                .findByEnrollment(enrollment)
                .orElseThrow(EntityNotFoundException::new);
    }
    
    public List<Student> findAllStudents(){
        return this.studentRepository.findAll();
    }

    public Student updateStudent(String enrollment, StudentUpdateDTO studentDTO) throws EntityNotFoundException{
        Student studentToSave = findStudentByEnrollment(enrollment);
        updateStudentFromDTO(studentToSave, studentDTO);
        return this.studentRepository.save(studentToSave);
    }

    public void deleteStudentById(String enrollment){
        this.studentRepository.deleteByEnrollment(enrollment);
    }

    private Student createStudentFromDTO(StudentBodyDTO studentDTO){
        return new Student( 
            studentDTO.getEnrollment(),
            studentDTO.getName(),
            studentDTO.getLastName(), 
            studentDTO.getGrade(), 
            studentDTO.getEmail());
    }

    private void updateStudentFromDTO(Student student, StudentUpdateDTO dto){
        student.setEmail(dto.getEmail());
        student.setGrade(dto.getGrade());
        student.setLastName(dto.getLastName());
        student.setName(dto.getName());
    }

}
