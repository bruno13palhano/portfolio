package com.bruno13palhano.repository;

import com.bruno13palhano.Project;
import com.bruno13palhano.model.ProjectData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProjectDAO extends CrudRepository<ProjectData, Integer> {
    @Query(value = "SELECT * FROM project_data p WHERE p.id = :id", nativeQuery = true)
    ProjectData findProjectById(@Param("id") Integer id);

    @Query(value = "DELETE FROM project_data p WHERE p.id = :id", nativeQuery = true)
    Project deleteProjectById(@Param("id") Integer id);

    @Query(value = "UPDATE project_data p SET p.name = :project.name, p.type = :project.type, p.description = :project.description " +
            "WHERE p.id = :project.id", nativeQuery = true)
    void updateProject(@Param("project") ProjectData project);
}
