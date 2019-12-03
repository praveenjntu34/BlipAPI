package com.at2t.blip.repository;

import com.at2t.blip.dao.LoginCredential;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginCredentialRepository extends CrudRepository<LoginCredential, Integer> {
	@Query("SELECT lc FROM LoginCredential lc WHERE Email= :email")
	Optional<LoginCredential> findByEmail(String email);

	@Modifying
	@Query(value = "INSERT INTO LoginCredential(PersonId,Email,PhoneNumber) VALUES(:PersonId,:Email,:PhoneNumber)", nativeQuery = true)
	public void addLoginCrendentials(@Param("PersonId") int personId, @Param("Email") String email,
			@Param("PhoneNumber") String phoneNumber);

}
