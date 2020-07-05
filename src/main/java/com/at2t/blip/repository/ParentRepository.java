package com.at2t.blip.repository;

import com.at2t.blip.dto.InstitutionResponse;
import com.at2t.blip.dto.ParentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Parent;

import java.util.List;


public interface ParentRepository extends PagingAndSortingRepository<Parent, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Parent(SecondaryPhoneNumber,PersonId,RelTenantInstitutionId) VALUES(:secondaryPhoneNumber,:personId,:relTenantInstitutionId)", nativeQuery = true)
	public void addParent(@Param("secondaryPhoneNumber") String secondaryPhoneNumber,
			@Param("personId") int personId, @Param("relTenantInstitutionId") int relTenantInstitutionId);

	@Query(value = "\n" +
			"SELECT new com.at2t.blip.dto.ParentResponseDto(C.childId, PR.firstName, PR.lastName, LC.email, LC.PhoneNumber,\n" +
			"PR.personId, LC.LoginCredentialId, P.parentId, P.secondaryParentName, P.secondaryPhoneNumber, C.admissionId) FROM Child C\n" +
			"JOIN C.parent P\n" +
			"JOIN P.personId PR\n" +
			"JOIN PR.loginCredential LC\n" +
			"WHERE P.relTenantInstitutionId = :relTenantInstitutionId")
	Page<ParentResponseDto> getAllParents(@Param("relTenantInstitutionId") Integer relTenantInstitutionId, Pageable pageable);

	@Query(nativeQuery = true)
	List<ParentResponseDto> getSingleParent(@Param("childId") int childId);

	@Modifying
	@Query(value = "Delete from Parent where ParentId=:parentId", nativeQuery = true)
	public void deleteParent(@Param("parentId") int parentId);

	@Modifying
	@Query(value = "update Parent set SecondaryPhoneNumber=:secondaryPhoneNumber , PersonId =:personId ,RelTenantInstitutionId =:relTenantInstitutionId where ParentId=:parentId", nativeQuery = true)
	public void updateParent(@Param("secondaryPhoneNumber") String secondaryPhoneNumber,
			@Param("personId") int personId, @Param("relTenantInstitutionId") int relTenantInstitutionId,@Param("parentId") int parentId);

	@Query(value = "\n" +
			"SELECT new com.at2t.blip.dto.ParentResponseDto(C.childId, PR.firstName, PR.lastName, LC.email, LC.PhoneNumber,\n" +
			"PR.personId, LC.LoginCredentialId, P.parentId, P.secondaryParentName, P.secondaryPhoneNumber, C.admissionId) FROM Child C\n" +
			"JOIN C.parent P\n" +
			"JOIN P.personId PR\n" +
			"JOIN PR.loginCredential LC\n" +
			"WHERE C.admissionId like %:admissionId%")
	 List<ParentResponseDto> getParentsByAdmissionId(@Param("admissionId") String admissionId);
}
