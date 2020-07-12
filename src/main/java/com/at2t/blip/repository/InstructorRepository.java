package com.at2t.blip.repository;

import com.at2t.blip.dto.InstitutionResponse;
import com.at2t.blip.dto.InstitutionResponseDto;
import com.at2t.blip.dto.InstructorLoginResponse;
import com.at2t.blip.dto.InstructorResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

	@Query(value = "INSERT INTO Instructor(PersonId,Designation,RelTenantInstitutionId,SectionId, Enabled, Image) OUTPUT inserted.InstructorId  VALUES(:personId,:designation,:relTenantInstitutionId, :sectionId, :enabled, :image)", nativeQuery = true)
	public int addInstructor(@Param("personId") int personId, @Param("designation") String designation,
							 @Param("relTenantInstitutionId") int relTenantInstitutionId, @Param("sectionId") int sectionId,
							 @Param("enabled") Boolean enabled, @Param("image") String image);

	@Modifying
	@Query(value = "Delete from Instructor where InstructorId=:instructorId", nativeQuery = true)
	public void deleteInstructor(@Param("instructorId") int instructorId);

	@Modifying
	@Query(value = "update Instructor set PersonId=:personId , SectionId =:sectionId where InstructorId=:instructorId", nativeQuery = true)
	public void updateInstructor(@Param("personId") int personId, @Param("sectionId") int sectionId,
			@Param("instructorId") int instructorId);

	@Query(value = "SELECT new com.at2t.blip.dto.InstructorResponseDto(I.instructorId, I.designation, P.firstName, " +
			"P.lastName, L.email, L.PhoneNumber, I.relTenantInstitutionId, S.sectionId, L.LoginCredentialId, " +
			"P.personId, S.branchId, I.enabled, I.image) FROM Instructor I\n " +
			"JOIN I.person P\n" +
			"JOIN I.section S\n" +
			"JOIN P.loginCredential L\n" +
			"WHERE RelTenantInstitutionId = :relTenantInstitutionId")
	Page<InstructorResponseDto> getInstructorDetails(@Param("relTenantInstitutionId") int id, Pageable pageable);
//	Optional<Instructor> getInstructorDetails();


	@Query(value = "\n" +
			"SELECT new com.at2t.blip.dto.InstructorLoginResponse(I.instructorId, S.sectionId, P.firstName, P.lastName, I.relTenantInstitutionId) FROM Instructor I\n" +
			"JOIN I.person P\n" +
			"JOIN I.section S\n" +
			"JOIN P.loginCredential L\n" +
			"WHERE L.PhoneNumber = :phoneNumber")
	InstructorLoginResponse loginInstructor(@Param("phoneNumber") String phoneNumber);


}
