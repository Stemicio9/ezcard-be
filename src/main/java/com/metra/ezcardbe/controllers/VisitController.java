package com.metra.ezcardbe.controllers;

import com.metra.ezcardbe.services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visit")
public class VisitController {

    private final ProfileService profileService;

    public VisitController(ProfileService profileService) {
        this.profileService = profileService;
    }

    //receive id from request
    @GetMapping("/get")
    public ResponseEntity getProfile(@RequestParam("username") String username) {
        return ResponseEntity.ok(profileService.findByUsername(username));
    }

}
