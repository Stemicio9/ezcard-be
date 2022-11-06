package com.metra.ezcardbe.security.services;

import com.metra.ezcardbe.entities.UserEz;
import com.metra.ezcardbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEz user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return user;
    }


    //insert user
    public UserEz insertUser(UserEz user) {
        user.setPassword(passEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //list users
    public ArrayList<UserEz> listUsers() {
        return (ArrayList<UserEz>) userRepository.findAll();
    }

    //delete user
    public void deleteUser(UserEz user) {
        userRepository.delete(user);
    }

}