package com.portfolio.api.controllers;

import com.portfolio.api.entity.SkillProfile;
import com.portfolio.api.repository.SkillProfileRepository;
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
@RequestMapping("/api/skillProfile")

public class SkillProfileController {

    @Autowired
    SkillProfileRepository skillProfileRepository;

    @GetMapping
    public ResponseEntity<List<SkillProfile>> getAll() {
        var skillProfile = skillProfileRepository.findAll();
        return new ResponseEntity<>(skillProfile, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillProfile> getSingle(@PathVariable("id") long id) {
        var skillProfile = skillProfileRepository.findById(id);

        return skillProfile.isPresent()
                ? new ResponseEntity<>(skillProfile.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<SkillProfile> create(@RequestBody SkillProfile skillProfile) {
        var persistedSkillProfile = skillProfileRepository.save(skillProfile);
        return new ResponseEntity<>(persistedSkillProfile, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillProfile> update(@PathVariable("id") long id, @RequestBody SkillProfile skillProfile) {
        var persistedSkillProfileData = skillProfileRepository.findById(id);

        if (persistedSkillProfileData.isPresent() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var persistedSkillProfile = persistedSkillProfileData.get();
        persistedSkillProfile.setSkill(skillProfile.getSkill());
        persistedSkillProfile.setPercentage(skillProfile.getPercentage());
       // persistedSkillProfile.setProfile(skillProfile.getProfile()); useless? >??

        return new ResponseEntity<>(skillProfileRepository.save(persistedSkillProfile), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        skillProfileRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
