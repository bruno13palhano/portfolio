package com.bruno13palhano.repository;

import com.bruno13palhano.Project;
import com.bruno13palhano.model.ProjectData;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.StreamSupport;

@Configuration
public class ProjectRepository implements CommonRepository<Project> {
    private final ProjectDAO projectDAO;

    ProjectRepository(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public void insert(Project model) {
        projectDAO.save(projectAsProjectData(model));
    }

    @Override
    public void delete(Project model) {
        projectDAO.delete(projectAsProjectData(model));
    }

    @Override
    public void update(Project model) {
        projectDAO.updateProject(projectAsProjectData(model));
    }

    @Override
    public List<Project> getAll() {
        List<ProjectData> result = StreamSupport.stream(projectDAO.findAll().spliterator(), false).toList();

        return result.stream().map(this::projectDataAsProject).toList();
    }

    @Override
    public Project getById(Integer id) {
        return projectDataAsProject(projectDAO.findProjectById(id));
    }

    private Project projectDataAsProject(ProjectData projectData) {
        return new Project(
                projectData.getId(),
                projectData.getName(),
                projectData.getType(),
                projectData.getDescription()
            );
    }

    private ProjectData projectAsProjectData(Project project) {
        return new ProjectData(
                project.getId(),
                project.getName(),
                project.getType(),
                project.getDescription()
            );
    }
}
