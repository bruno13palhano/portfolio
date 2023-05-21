package com.bruno13palhano.portfolio.controllers;

import com.bruno13palhano.portfolio.datasource.model.Project;
import com.bruno13palhano.portfolio.datasource.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewProject(
        @RequestParam String name,
        @RequestParam String type,
        @RequestParam String description
    ) {
        Project project = new Project();
        project.setName(name);
        project.setType(type);
        project.setDescription(description);
        projectRepository.save(project);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Project getProjectById(@PathVariable Integer id) {
        return projectRepository.findProjectById(id);
    }
}
