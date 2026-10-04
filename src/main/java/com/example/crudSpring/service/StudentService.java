package com.example.crudSpring.service;

import com.example.crudSpring.entity.Student;
import com.example.crudSpring.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq){
        Student studentResp = studentRepository.save(studentReq); // use JPA save method
        return studentResp;
    }
    public Student getStudent(Long id){
        Optional<Student> getStudentResp = studentRepository.findById(id); // ye optional ka use karega
        // kyoki if Id DB me present n ho to optional ka mean kuch ho bhi sakta hai or nhi bhi

        if(getStudentResp.isPresent()){ // if data hai toh
            return getStudentResp.get(); // optional me se student record ko fetch kar ker ke return kar diya
        }
        return null;
    }

    public List<Student> getAllStudents(){
        List<Student>findAllStudents = studentRepository.findAll();
        return findAllStudents;
    }

    public Student updateStudent(Long id,
                                 @RequestBody Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student saveToStudent = existingStudent.get();


        saveToStudent.setName(studentReq.getName());
        saveToStudent.setAge(studentReq.getAge());
        saveToStudent.setGmail(studentReq.getGmail());
        saveToStudent.setSubject(studentReq.getSubject());

        return studentRepository.save(saveToStudent);
    }

    public boolean deleteStudent(Long id){
        boolean isExist = studentRepository.existsById(id);
        if(!isExist){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
