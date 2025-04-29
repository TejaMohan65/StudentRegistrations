package com.example.Studentauth.service;
import com.example.Studentauth.DTOs.StudentDTO;
import com.example.Studentauth.models.Student;

import java .util.List;

public interface StudentService {



     String save(StudentDTO studentDTO);

    public Student getById(Integer id);

    public List <Student> getAllStudent();

    public String deleteById(Integer id);
}
