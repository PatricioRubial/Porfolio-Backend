package com.portfolio.api.controllers;

import com.portfolio.api.entity.Study;
import com.portfolio.api.repository.StudyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/study")

public class StudyController {

    @Autowired
    StudyRepository studyRepository;

    @GetMapping
    public ResponseEntity<List<Study>> getAll() {
        var study = studyRepository.findAll();
        return new ResponseEntity<>(study, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Study> getSingle(@PathVariable("id") long id) {
        var study = studyRepository.findById(id);

        return study.isPresent()
                ? new ResponseEntity<>(study.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Study> create(@RequestBody Study study) {
        var persistedStudy = studyRepository.save(study);
        return new ResponseEntity<>(persistedStudy, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Study> update(@PathVariable("id") long id, @RequestBody Study study) {
        var persistedStudyData = studyRepository.findById(id);

        var persistedStudy = persistedStudyData.get();
        persistedStudy.setName(study.getName());
        persistedStudy.setDescription(study.getDescription());
        persistedStudy.setInstitution(study.getInstitution());
        persistedStudy.setPhoto(study.getPhoto());
        persistedStudy.setLink(study.getLink());
        
        return new ResponseEntity<>(studyRepository.save(persistedStudy),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>delete(@PathVariable("id") long id)
    {
        studyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
