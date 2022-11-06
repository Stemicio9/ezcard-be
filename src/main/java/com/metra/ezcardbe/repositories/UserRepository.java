package com.metra.ezcardbe.repositories;

import com.metra.ezcardbe.entities.UserEz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends MongoRepository<UserEz, String> {

    java.util.Optional<UserEz> findByEmail(String email);

    java.util.Optional<UserEz> findByUsername(String username);
}
