package com.at2t.blip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.at2t.blip.dao.Section;

public interface SectionRepository extends CrudRepository<Section, Integer> {

	@Query("SELECT s FROM Section s WHERE branchId= :branchId")
	List<Section> getSection(int branchId);
}
