package com.at2t.blip.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Parent;


public interface ParentRepository extends CrudRepository<Parent, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Parent(SecondaryPhoneNumber,PersonId,RelTenantInstitutionId) VALUES(:secondaryPhoneNumber,:personId,:relTenantInstitutionId)", nativeQuery = true)
	public void addParent(@Param("secondaryPhoneNumber") String secondaryPhoneNumber,
			@Param("personId") int personId, @Param("relTenantInstitutionId") int relTenantInstitutionId);

	@Modifying
	@Query(value = "Delete from Parent where ParentId=:parentId", nativeQuery = true)
	public void deleteParent(@Param("parentId") int parentId);

	@Modifying
	@Query(value = "update Parent set SecondaryPhoneNumber=:secondaryPhoneNumber , PersonId =:personId ,RelTenantInstitutionId =:relTenantInstitutionId where ParentId=:parentId", nativeQuery = true)
	public void updateParent(@Param("secondaryPhoneNumber") String secondaryPhoneNumber,
			@Param("personId") int personId, @Param("relTenantInstitutionId") int relTenantInstitutionId,@Param("parentId") int parentId);
}
