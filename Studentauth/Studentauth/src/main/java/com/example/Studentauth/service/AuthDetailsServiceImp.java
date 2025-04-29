package com.example.Studentauth.service;

import com.example.Studentauth.DTOs.AuthDetailsDTO;
import com.example.Studentauth.Repositories.AuthDetailRepository;
import com.example.Studentauth.Repositories.StudentRepository;
import com.example.Studentauth.models.AuthDetails;
import com.example.Studentauth.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthDetailsServiceImp implements AuthDetailsService{

    @Autowired
    private AuthDetailRepository authDetailRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public boolean authenticateStudent(AuthDetailsDTO authDetailsDto) {
        Optional<AuthDetails> authDetails = authDetailRepository.findByUserName(authDetailsDto.getUserName());

        if (authDetails.isPresent() && authDetails.get().password.equals(authDetailsDto.getPassword())) {
            // Authentication successful, return the list of students
            return true;
        }

        // Authentication failed, return an empty list or handle as needed
        return false;
    }
}
