package com.metra.ezcardbe.repositories;

import com.metra.ezcardbe.entities.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

    Profile findByEmail(String email);

    Profile findByUsername(String username);
    Optional<Profile> findById(String id);



}

