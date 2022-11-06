package com.metra.ezcardbe.controllers;

import com.metra.ezcardbe.entities.Profile;
import com.metra.ezcardbe.entities.UserEz;
import com.metra.ezcardbe.security.JwtRequest;
import com.metra.ezcardbe.security.services.JwtUserDetailsService;
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

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    //Update profile
    @PutMapping("/update")
    public ResponseEntity updateProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }

    //Insert profile
    @PostMapping("/insert")
    public ResponseEntity insertProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.insertProfile(profile));
    }

    //Get User by username
    @GetMapping("/get/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(jwtUserDetailsService.loadUserByUsername(username));
    }


    //Create user
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody JwtRequest request) {
        Profile profile = new Profile();
        profile.setUsername(request.getUsername());
        insertProfile(profile);
        UserEz user = new UserEz(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(jwtUserDetailsService.insertUser(user));
    }

    // List all users
    @GetMapping("/list")
    public ResponseEntity listUsers() {
        return ResponseEntity.ok(jwtUserDetailsService.listUsers());
    }



}
