package com.bruno13palhano.portfolio.controllers;

import com.bruno13palhano.Project;
import com.bruno13palhano.repository.ProjectRepository;
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
        projectRepository.insert(project);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Project> getAllProjects() {
        return projectRepository.getAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Project getProjectById(@PathVariable Integer id) {
        return projectRepository.getById(id);
    }
}
