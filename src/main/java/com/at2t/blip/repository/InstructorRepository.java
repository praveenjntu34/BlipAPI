package com.at2t.blip.repository;

import com.at2t.blip.dto.InstitutionResponseDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Instructor(PersonId,Designation,RelTenantInstitutionId,SectionId) VALUES(:personId,:designation,:relTenantInstitutionId, :sectionId)", nativeQuery = true)
	public void addInstructor(@Param("personId") int personId, @Param("designation") String designation, @Param("relTenantInstitutionId") int relTenantInstitutionId, @Param("sectionId") int sectionId);

	@Modifying
	@Query(value = "Delete from Instructor where InstructorId=:instructorId", nativeQuery = true)
	public void deleteInstructor(@Param("instructorId") int instructorId);

	@Modifying
	@Query(value = "update Instructor set PersonId=:personId , SectionId =:sectionId where InstructorId=:instructorId", nativeQuery = true)
	public void updateInstructor(@Param("personId") int personId, @Param("sectionId") int sectionId,
			@Param("instructorId") int instructorId);

	@Query(value = "SELECT I.instructorId, I.designation, P.firstName, P.lastName, L.email, L.PhoneNumber, I.relTenantInstitutionId, S.sectionId FROM Instructor I\n " +
			"JOIN I.person P\n" +
			"JOIN I.section S\n" +
			"JOIN P.loginCredential L\n" +
			"WHERE RelTenantInstitutionId = :relTenantInstitutionId")
	List<Object[]> getInstructorDetails(@Param("relTenantInstitutionId") int id);
//	Optional<Instructor> getInstructorDetails();
}
