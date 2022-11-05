package com.metra.ezcardbe.controllers;

import com.metra.ezcardbe.entities.Profile;
import com.metra.ezcardbe.security.JwtRequest;
import com.metra.ezcardbe.security.services.JwtUserDetailsService;
import com.metra.ezcardbe.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping ("/profile")
public class ProfileController {


    @Autowired
    private ProfileService profileService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


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


    //Create user
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody JwtRequest request) {
        Profile profile = new Profile();
        profile.setUsername(request.getUsername());
        insertProfile(profile);
        User user = new User(request.getUsername(), request.getPassword(), null);
        return ResponseEntity.ok(jwtUserDetailsService.insertUser(user));
    }

    // List all users
    @GetMapping("/list")
    public ResponseEntity listUsers() {
        return ResponseEntity.ok(jwtUserDetailsService.listUsers());
    }



}
