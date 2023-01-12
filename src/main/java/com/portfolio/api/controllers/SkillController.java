package com.portfolio.api.controllers;

import com.portfolio.api.entity.Skill;
import com.portfolio.api.repository.SkillRepository;
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
@RequestMapping("/api/skill")

public class SkillController {
    
        @Autowired
    SkillRepository skillRepository;

        @GetMapping
    public ResponseEntity<List<Skill>> getAll() {
        var skill = skillRepository.findAll();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }   
    
            @GetMapping("/{id}")
    public ResponseEntity<Skill> getSingle(@PathVariable("id") long id) {
        var skill = skillRepository.findById(id);

        return skill.isPresent()
                ? new ResponseEntity<>(skill.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
          @PostMapping
    public ResponseEntity<Skill> create(@RequestBody Skill skill) {
        var persistedSkill = skillRepository.save(skill);
        return new ResponseEntity<>(persistedSkill, HttpStatus.CREATED);
    }
    
       @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable("id") long id, @RequestBody Skill skill) {
        var persistedSkillData = skillRepository.findById(id);

        if (persistedSkillData.isPresent() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var persistedSkill = persistedSkillData.get();
        persistedSkill.setName(skill.getName());
          persistedSkill.setIcon(skill.getIcon());
       
        return new ResponseEntity<>(skillRepository.save(persistedSkill), HttpStatus.OK);
    }
    
        @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        skillRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
