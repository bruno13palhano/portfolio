package com.bruno13palhano.portfolio.datasource.repository;

import com.bruno13palhano.portfolio.datasource.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    @Query(value = "SELECT * FROM project p WHERE p.id = :id", nativeQuery = true)
    Project findProjectById(@Param("id") Integer id);
}
