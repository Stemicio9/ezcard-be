package com.metra.ezcardbe.controllers;

import com.metra.ezcardbe.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private ProfileService profileService;

    //receive id from request
    @GetMapping("/get")
    public ResponseEntity getProfile(@RequestParam("id") String id) {
        return ResponseEntity.ok(profileService.getProfileFromDB(id));
    }

}
