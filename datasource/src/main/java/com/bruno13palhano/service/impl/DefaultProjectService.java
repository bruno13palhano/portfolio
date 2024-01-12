package com.bruno13palhano.service.impl;

import com.bruno13palhano.Project;
import com.bruno13palhano.repository.ProjectRepository;
import com.bruno13palhano.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {
    private final ProjectRepository projectRepository;

    public DefaultProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void insert(Project model) {
        projectRepository.insert(model);
    }

    @Override
    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void update(Project model) {
        projectRepository.update(model);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public Project getById(Integer id) {
        return projectRepository.getById(id);
    }
}
