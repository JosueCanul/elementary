package com.elementary.mx.elementary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.model.Student;
import com.elementary.mx.elementary.model.DTO.CreateStudentDTO;
import com.elementary.mx.elementary.repository.StudentRepository;
import com.elementary.mx.elementary.repository.mapper.StudentMapper;
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public Student findStudentById(String enrollment) throws Exception{
        return studentRepository.findById(enrollment).orElseThrow();
    }

    public Student saveStudent(Student student){
        return this.studentRepository.save(student);
    }

    public void deleteStudentById(String enrollment){
        this.studentRepository.deleteById(enrollment);
    }

    public void updateStudent(Student student) {
        Student studentToSave = this.studentRepository.findById(student.getEnrolment())
            .map(s -> {
                this.studentMapper.updateStudentFromRecord(student, s);
                return s;
            })
            .orElse(student);
        this.studentRepository.save(studentToSave);
    }

    public List<Student> listStudents(){
        return this.studentRepository.findAll();
    }

    public void createStudent(CreateStudentDTO data){
        // LLAMA AL REPOSITORIO Y CREA EL ESTUDIANTE
    }
}
