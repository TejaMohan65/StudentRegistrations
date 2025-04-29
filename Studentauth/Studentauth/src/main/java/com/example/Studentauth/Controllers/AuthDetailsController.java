package com.example.Studentauth.Controllers;

import com.example.Studentauth.DTOs.AuthDetailsDTO;
import com.example.Studentauth.models.AuthDetails;
import com.example.Studentauth.models.Student;
import com.example.Studentauth.service.AuthDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthDetailsController {
    @Autowired
     private AuthDetailsService authDetailsService;


    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity authenticateStudent(@RequestBody AuthDetailsDTO authDetailsDto) {
        boolean authenticated = authDetailsService.authenticateStudent(authDetailsDto);

        if (!authenticated) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("not autherized");
        }

        return ResponseEntity.status(HttpStatus.OK).body("autherized");
    }

}

