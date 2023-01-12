package com.portfolio.api.controllers;

import com.portfolio.api.entity.Project;
import com.portfolio.api.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/projects")

public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        var projects = projectRepository.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getSingle(@PathVariable("id") long id) {
        var project = projectRepository.findById(id);

        return project.isPresent()
                ? new ResponseEntity<>(project.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {
        var persistedProject = projectRepository.save(project);
        return new ResponseEntity<>(persistedProject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable("id") long id, @RequestBody Project project) {
        var persistedProjectData = projectRepository.findById(id);

        if (persistedProjectData.isPresent() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var persistedProject = persistedProjectData.get();
        persistedProject.setName(project.getName());
        persistedProject.setDescription(project.getDescription());
        persistedProject.setPhoto(project.getPhoto());

        return new ResponseEntity<>(projectRepository.save(persistedProject), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        projectRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
