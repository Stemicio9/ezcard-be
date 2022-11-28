package com.metra.ezcardbe.controllers;

import com.metra.ezcardbe.entities.*;
import com.metra.ezcardbe.security.JwtRequest;
import com.metra.ezcardbe.security.services.JwtUserDetailsService;
import com.metra.ezcardbe.services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/profile")
public class ProfileController {


    private final ProfileService profileService;
    private final JwtUserDetailsService jwtUserDetailsService;

    public ProfileController(ProfileService profileService, JwtUserDetailsService jwtUserDetailsService) {
        this.profileService = profileService;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.insertProfile(profile));
    }

    @GetMapping("/get/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(jwtUserDetailsService.loadUserByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody JwtRequest request) {
        Profile profile = new Profile();
        profile.setUsername(request.getUsername());
        insertProfile(profile);
        UserEz user = new UserEz(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(jwtUserDetailsService.insertUser(user));
    }

    @GetMapping("/list")
    public ResponseEntity listUsers() {
        return ResponseEntity.ok(jwtUserDetailsService.listUsers());
    }


    //TODO presentation, gallery, partner

    @PostMapping("/update/profile")
    public ResponseEntity updateProfile(Authentication authentication, @RequestBody ProfileContainer profile) {
        return ResponseEntity.ok(profileService.updateProfile(profile, authentication.getName()));
    }

    @PostMapping("/update/social")
    public ResponseEntity updateSocial(Authentication authentication, @RequestBody List<SocialContainer> socialContainerList) {
        return ResponseEntity.ok(profileService.updateSocial(socialContainerList, authentication.getName()));
    }

    @PostMapping("/update/contacts")
    public ResponseEntity updateContacts(Authentication authentication, @RequestBody List<ContactContainer> contactContainerList) {
        return ResponseEntity.ok(profileService.updateContacts(contactContainerList, authentication.getName()));
    }
    @PostMapping("/update/company")
    public ResponseEntity updateCompanies(Authentication authentication, @RequestBody List<CompanyContainer> companyContainers) {
        return ResponseEntity.ok(profileService.updateCompanies(companyContainers, authentication.getName()));
    }


    @PostMapping("/get/profile")
    public ResponseEntity getProfile(Authentication authentication) {
        return ResponseEntity.ok(profileService.getProfile(authentication.getName()));
    }

    @PostMapping("/get/social")
    public ResponseEntity getSocial(Authentication authentication) {
        return ResponseEntity.ok(profileService.getSocial(authentication.getName()));
    }

    @PostMapping("/get/contacts")
    public ResponseEntity getContacts(Authentication authentication) {
        return ResponseEntity.ok(profileService.getContacts(authentication.getName()));
    }
    @PostMapping("/get/company")
    public ResponseEntity getCompanies(Authentication authentication) {
        return ResponseEntity.ok(profileService.getCompanies(authentication.getName()));
    }


}
