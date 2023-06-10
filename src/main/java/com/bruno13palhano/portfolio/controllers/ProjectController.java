package com.bruno13palhano.portfolio.controllers;

import com.bruno13palhano.Project;
import com.bruno13palhano.Technologies;
import com.bruno13palhano.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(path = "/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping(path = "/add")
    public String addNewProject(
        @RequestParam String name,
        @RequestParam List<Technologies> type,
        @RequestParam String description,
        @RequestParam List<String> imagesUrls
    ) {
        Project project = new Project();
        project.setName(name);
        project.setType(type);
        project.setDescription(description);
        project.setImagesUrls(imagesUrls);
        projectRepository.insert(project);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Project> getAllProjects() {
        return projectRepository.getAll();
    }

    @GetMapping(path = "{id}")
    public Project getProjectById(@PathVariable Integer id) {
        return projectRepository.getById(id);
    }

    @PutMapping(path = "/update")
    public String updateProject(
        @RequestParam Integer id,
        @RequestParam String name,
        @RequestParam List<Technologies> type,
        @RequestParam String description,
        @RequestParam List<String> imageUrls
    ) {
        Project project = new Project();
        project.setId(id);
        project.setName(name);
        project.setType(type);
        project.setDescription(description);
        project.setImagesUrls(imageUrls);
        projectRepository.update(project);

        return "Updated";
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> getProjectImage(@RequestParam String name, @RequestParam Integer id) throws IOException {
        ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                     "src/main/resources/assets/images/projects/"+name+"_"+id+".png"
        )));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }
}
