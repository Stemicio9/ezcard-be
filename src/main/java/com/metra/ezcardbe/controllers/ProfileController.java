package com.metra.ezcardbe.controllers;

import com.metra.ezcardbe.entities.Profile;
import com.metra.ezcardbe.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping ("/profile")
public class ProfileController {


    @Autowired
    private ProfileService profileService;


    //Update profile
    @PostMapping("/update")
    public ResponseEntity updateProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }

    //Insert profile
    @PostMapping("/insert")
    public ResponseEntity insertProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.insertProfile(profile));
    }


}
