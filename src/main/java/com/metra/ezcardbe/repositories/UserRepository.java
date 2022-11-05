package com.metra.ezcardbe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends MongoRepository<User, String> {

    java.util.Optional<User> findByEmail(String email);

    java.util.Optional<User> findByUsername(String username);
}
