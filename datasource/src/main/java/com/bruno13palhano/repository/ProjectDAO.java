package com.bruno13palhano.repository;

import com.bruno13palhano.model.ProjectData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProjectDAO extends CrudRepository<ProjectData, Integer> {
    @Query(value = "SELECT * FROM project p WHERE p.id = :id", nativeQuery = true)
    ProjectData findProjectById(@Param("id") Integer id);
}