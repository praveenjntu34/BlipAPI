package com.at2t.blip.repository;

import java.util.List;

import com.at2t.blip.dto.BranchResponseDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Branch;

public interface BranchRepository extends CrudRepository<Branch, Integer> {

	@Query(value = "SELECT B FROM Branch B WHERE B.relTenantInstitutionId = :relTenantInstitutionId")
	List<Branch> findBranches(int relTenantInstitutionId);
}
