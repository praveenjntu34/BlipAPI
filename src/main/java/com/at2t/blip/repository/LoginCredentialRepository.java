package com.at2t.blip.repository;

import com.at2t.blip.dao.LoginCredential;

import com.at2t.blip.dto.InstitutionResponse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LoginCredentialRepository extends CrudRepository<LoginCredential, Integer> {
	@Query("SELECT lc FROM LoginCredential lc WHERE Email= :email")
	Optional<LoginCredential> findByEmail(String email);

	@Query(value = "INSERT INTO LoginCredential(PersonId,Email,PhoneNumber, Passcode) OUTPUT inserted.LoginCredentialId VALUES(:PersonId,:Email,:PhoneNumber, :Passcode)", nativeQuery = true)
	public int addLoginCrendentials(@Param("PersonId") int personId, @Param("Email") String email, @Param("Passcode") String passcode,
			@Param("PhoneNumber") String phoneNumber);

	@Query("SELECT lc FROM LoginCredential lc WHERE PersonId= :personId")
	Optional<LoginCredential> getPersonDetails(int personId);

	@Query(value = "SELECT LC.Email, LC.PhoneNumber, P.PersonId, P.FirstName, P.LastName, PT.PersonTypeId, PT.PersonTypeName FROM LoginCredential LC\n" +
			"JOIN Person P ON P.PersonId = LC.PersonId\n" +
			"JOIN PersonType PT ON PT.PersonTypeId = P.PersonTypeId\n" +
			"WHERE LC.Email= :email", nativeQuery = true)
	List<Object[]>  getLogin(String email);
}
