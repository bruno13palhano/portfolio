package com.bruno13palhano.portfolio.controllers;

import com.bruno13palhano.Project;
import com.bruno13palhano.service.ProjectService;
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
@RequestMapping(path = "/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Project project) {
        projectService.insert(project);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok().body(projectService.getAll());
    }

    @GetMapping(path = "/project/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Integer id) {
        Project project = projectService.getById(id);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Project project) {
        projectService.update(project);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        projectService.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
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
