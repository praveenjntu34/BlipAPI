package com.at2t.blip.repository;

import com.at2t.blip.dto.BranchDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import com.at2t.blip.dao.InstitutionAdmin;

public interface InstitutionAdminRepository extends CrudRepository<InstitutionAdmin, Integer> {
	@Modifying
	@Query(value = "INSERT INTO InstitutionAdmin(SecondaryPOCName,RelTenantInstitutionId,PersonId,SecondaryPOCEmail,SecondaryPOCPhoneNumber) VALUES(:SecondaryPOCName,:RelTenantInstitutionId,:PersonId,:SecondaryPOCEmail,:SecondaryPOCPhoneNumber)", nativeQuery = true)
	public void addInstitutionData(@Param("SecondaryPOCName") String secondaryPOCName,
			@Param("RelTenantInstitutionId") int relTenantInstitutionId, @Param("PersonId") int personId,
			@Param("SecondaryPOCEmail") String secondaryPOCEmail,
			@Param("SecondaryPOCPhoneNumber") String secondaryPOCPhoneNumber);

	@Query(value = "INSERT INTO Branch(BranchName,RelTenantInstitutionId) OUTPUT inserted.BranchId VALUES(:BranchName,:RelTenantInstitutionId)", nativeQuery = true)
	public int addBranch(@Param("BranchName") String branchName,
							   @Param("RelTenantInstitutionId") int relTenantInstitutionId);

	@Modifying
	@Query(value = "INSERT INTO Section(SectionName,BranchId) VALUES(:SectionName,:BranchId)", nativeQuery = true)
	public void addSection(@Param("SectionName") String sectionName, @Param("BranchId") int branchId);

	
	
}
