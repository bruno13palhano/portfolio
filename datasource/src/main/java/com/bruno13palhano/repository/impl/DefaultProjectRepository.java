package com.bruno13palhano.repository;

import com.bruno13palhano.Project;
import com.bruno13palhano.service.ProjectService;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.util.List;

@Configuration
public class ProjectRepository implements Repository<Project> {
    private final Connection connection;

    ProjectRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void insert(Project model) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Project model) {

    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project getById(Integer id) {
        return null;
    }
}
