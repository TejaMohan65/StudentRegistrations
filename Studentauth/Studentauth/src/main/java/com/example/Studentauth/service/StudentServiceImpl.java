package com.example.Studentauth.service;
import com.example.Studentauth.DTOs.StudentDTO;
import com.example.Studentauth.Repositories.AuthDetailRepository;
import com.example.Studentauth.Repositories.StudentRepository;
import com.example.Studentauth.models.AuthDetails;
import com.example.Studentauth.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class StudentServiceImpl implements StudentService{
  @Autowired
  private StudentRepository studentRepo;
  @Autowired
  private AuthDetailRepository authRepo;
  @Override
    public String save(StudentDTO studentDTO){
      Student newStudent = new Student();
      newStudent.rollNumber = studentDTO.rollNumber;
      newStudent.email = studentDTO.email;
      newStudent.name = studentDTO.name;
      AuthDetails newAuthDetails = new AuthDetails();
      newAuthDetails.userName = studentDTO.rollNumber;
      newAuthDetails.password = studentDTO.password;

    studentRepo.save(newStudent); // (Insert / Update based on PK)
    authRepo.save(newAuthDetails)  ;
      return "success";
  }


    @Override
    public Student getById(Integer id) {
       Optional<Student> findByid =  studentRepo.findById(id);
            if(findByid.isPresent()){
                return findByid.get();
            }
            return null;
    }

    @Override
    public List<Student> getAllStudent() {
       return studentRepo.findAll();

    }

    @Override
    public String deleteById(Integer id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Delete Success";
        } else {
            return "No Records Found";
        }
    }
}
