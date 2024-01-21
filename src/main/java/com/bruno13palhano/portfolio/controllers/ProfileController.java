package com.bruno13palhano.portfolio.controllers;

import com.bruno13palhano.Profile;
import com.bruno13palhano.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/profiles")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody Profile profile) {
        profileService.insert(profile);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Profile profile) {
        profileService.update(profile);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/profile")
    public ResponseEntity<Profile> getById() {
        Profile profile = profileService.getById(1);

        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
