package com.example.Studentauth.Repositories;

import com.example.Studentauth.models.AuthDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthDetailRepository extends JpaRepository<AuthDetails, Integer> {
    Optional<AuthDetails> findByUserName(String userName);
}

