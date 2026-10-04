package com.example.crudSpring.controller;

import com.example.crudSpring.entity.Student;
import com.example.crudSpring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Create
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    //Read
    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable Long id){ // --> /api/student/1 (Here 1 is path variable)
        Student studentResp = studentService.getStudent(id);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }

    //Read All student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student>studentsList = studentService.getAllStudents();
        if(studentsList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentsList);
    }
    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Student>updateStudent(@PathVariable Long id, @RequestBody Student studentreq){ // --> /api/student/1 (Here 1 is path variable)
        Student studentResp = studentService.updateStudent(id, studentreq);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id){
        boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(true);
    }
}
