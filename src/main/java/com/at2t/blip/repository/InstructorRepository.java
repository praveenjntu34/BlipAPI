package com.at2t.blip.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Instructor(PersonId,SectionId) VALUES(:personId,:sectionId)", nativeQuery = true)
	public void addInstructor(@Param("personId") int personId, @Param("sectionId") int sectionId);

	@Modifying
	@Query(value = "Delete from Instructor where InstructorId=:instructorId", nativeQuery = true)
	public void deleteInstructor(@Param("instructorId") int instructorId);

	@Modifying
	@Query(value = "update Instructor set PersonId=:personId , SectionId =:sectionId where InstructorId=:instructorId", nativeQuery = true)
	public void updateInstructor(@Param("personId") int personId, @Param("sectionId") int sectionId,
			@Param("instructorId") int instructorId);
}
