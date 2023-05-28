package com.bruno13palhano.portfolio.controllers;

import com.bruno13palhano.model.ProjectData;
import com.bruno13palhano.repository.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/project")
public class ProjectController {

    @Autowired
    private ProjectDAO projectDAO;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewProject(
        @RequestParam String name,
        @RequestParam String type,
        @RequestParam String description
    ) {
        ProjectData projectData = new ProjectData();
        projectData.setName(name);
        projectData.setType(type);
        projectData.setDescription(description);
        projectDAO.save(projectData);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<ProjectData> getAllProjects() {
        return projectDAO.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ProjectData getProjectById(@PathVariable Integer id) {
        return projectDAO.findProjectById(id);
    }
}
