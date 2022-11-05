package com.metra.ezcardbe.security.services;

import com.metra.ezcardbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return user;
    }


    //insert user
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    //list users
    public ArrayList<User> listUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    //delete user
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}