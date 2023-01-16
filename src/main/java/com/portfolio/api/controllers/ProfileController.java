package com.portfolio.api.controllers;

import com.portfolio.api.entity.Profile;
import com.portfolio.api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/profiles")

public class ProfileController {

    @Autowired
    ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<Profile> myProfile() {
        var profile = profileRepository.findAll().get(0);
        profile.setPassword(new String());
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<Profile> create(@RequestBody LoginRequest request) {
        var profile = profileRepository.findAll().get(0);
        
        if (profile.getPassword().equals(request.getPassword()) == false || profile.getEmail().equals(request.getEmail()) == false) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        profile.setPassword(new String());
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> update(@PathVariable("id") long id, @RequestBody Profile profile) {
        var persistedProfileData = profileRepository.findById(id);

        if (persistedProfileData.isPresent() == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        var persistedProfile = persistedProfileData.get();

        persistedProfile.setName(profile.getName());
        persistedProfile.setTittle(profile.getTittle());
        persistedProfile.setDescription(profile.getDescription());
        persistedProfile.setPhoto(profile.getPhoto());
        persistedProfile.setGitHub(profile.getGitHub());
        persistedProfile.setLinkedIn(profile.getLinkedIn());

        return new ResponseEntity<>(profileRepository.save(persistedProfile), HttpStatus.OK);
    }
}


