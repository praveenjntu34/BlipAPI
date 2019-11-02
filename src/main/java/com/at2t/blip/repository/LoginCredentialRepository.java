package com.at2t.blip.repository;

import com.at2t.blip.model.LoginCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginCredentialRepository extends JpaRepository<LoginCredential, Integer> {
    Optional<LoginCredential> findByEmail(String email);
}
