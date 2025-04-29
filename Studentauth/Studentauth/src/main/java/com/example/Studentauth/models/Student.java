package com.example.Studentauth.models;

import java.util.Date;

import com.example.Studentauth.Constants.Branch;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(unique = true, nullable = false)
    public String rollNumber;

    @Column(nullable = false)
    public String name;

    @Column(unique = true, nullable = false)
    public String email;

    public Date dateOfBirth;

    public String address;

    public Branch branch;
    public String password;

}
