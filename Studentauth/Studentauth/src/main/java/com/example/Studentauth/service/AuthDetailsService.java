package com.example.Studentauth.service;

import com.example.Studentauth.DTOs.AuthDetailsDTO;
import com.example.Studentauth.models.AuthDetails;
import com.example.Studentauth.models.Student;

import java.util.List;

public interface AuthDetailsService {
    public boolean authenticateStudent(AuthDetailsDTO authDetailsDto);

}
