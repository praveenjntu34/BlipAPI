package com.at2t.blip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Branch;

public interface BranchRepository extends CrudRepository<Branch, Integer> {

	@Query("SELECT b FROM Branch b WHERE relTenantInstitutionId= :relTenantInstitutionId")
	List<Branch> findById(int relTenantInstitutionId);
}
