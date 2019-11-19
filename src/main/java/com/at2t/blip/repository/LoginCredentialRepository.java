package com.at2t.blip.repository;

import com.at2t.blip.dao.LoginCredential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginCredentialRepository extends CrudRepository<LoginCredential, Integer> {
    @Query("SELECT lc FROM LoginCredential lc WHERE Email= :email")
    Optional<LoginCredential> findByEmail(String email);
}
