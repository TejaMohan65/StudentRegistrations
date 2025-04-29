package com.example.Studentauth.Controllers;


import com.example.Studentauth.DTOs.StudentDTO;
import com.example.Studentauth.models.Student;
import com.example.Studentauth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO) {
        String status = studentService.save(studentDTO);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@RequestBody Integer id) {
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudent();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody StudentDTO studentDTO) {
        String status = studentService.save(studentDTO);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@RequestBody Integer id) {
        String status = studentService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
