package com.at2t.blip.repository;

import java.util.List;

import com.at2t.blip.dto.BranchResponseDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Branch;

public interface BranchRepository extends CrudRepository<Branch, Integer> {

	@Query(value = "SELECT new com.at2t.blip.dto.BranchResponseDto(B.branchId, B.branchName)" +
			" FROM Branch B  WHERE B.relTenantInstitution.relTenantInstitutionId = :relTenantInstitutionId")
	List<BranchResponseDto> findBranches(int relTenantInstitutionId);
}
