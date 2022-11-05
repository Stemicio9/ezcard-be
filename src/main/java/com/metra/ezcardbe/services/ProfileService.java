package com.metra.ezcardbe.services;

import com.metra.ezcardbe.entities.Profile;
import com.metra.ezcardbe.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile getProfile(String id) {
       //Create dummy profile
        Profile profile = new Profile();
        profile.setId(id);
        profile.setName("John");
        profile.setSurname("Doe");
        profile.setEmail("test@email.com");
        return profile;
    }

    public Profile getProfileFromDB(String id) {
        return profileRepository.findById(id).get();
    }

    // Update profile
    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    //Insert profile
    public Profile insertProfile(Profile profile) {
        return profileRepository.insert(profile);
    }

}
