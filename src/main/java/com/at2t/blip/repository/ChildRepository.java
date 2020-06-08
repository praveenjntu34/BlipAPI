package com.at2t.blip.repository;

import com.at2t.blip.dao.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.at2t.blip.dao.Parent;

import java.util.List;


public interface ChildRepository extends CrudRepository<Child, Integer> {

    @Query(value = "select * from Child where parentId = :parentId", nativeQuery = true)
    List<Child> findAllByParentId(@Param("parentId") int parentId);
}
