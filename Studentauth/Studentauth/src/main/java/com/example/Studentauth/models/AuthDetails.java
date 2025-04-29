package com.example.Studentauth.models;


import jakarta.persistence.*;

@Entity
public class AuthDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(nullable = false, unique = true)
    public String userName;
    public String password;
}
