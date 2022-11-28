package com.metra.ezcardbe.repositories;

import com.metra.ezcardbe.entities.UserEz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEz, String> {

    Optional<UserEz> findByEmail(String email);

    Optional<UserEz> findByUsername(String username);
}
