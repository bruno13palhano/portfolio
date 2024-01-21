package com.bruno13palhano.portfolio.controllers;

import com.bruno13palhano.Profile;
import com.bruno13palhano.service.ProfileService;
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

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> getProfileImage() throws IOException {
        ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                    "src/main/resources/assets/images/profile/profile.png"
        )));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }
}
