package com.metra.ezcardbe.security.services;

import com.metra.ezcardbe.entities.UserEz;
import com.metra.ezcardbe.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passEncoder;

    public JwtUserDetailsService(UserRepository userRepository, PasswordEncoder passEncoder) {
        this.userRepository = userRepository;
        this.passEncoder = passEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("STO CERCANDO UTENTE " + username);
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }

    public UserEz insertUser(UserEz user) {
        user.setPassword(passEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public ArrayList<UserEz> listUsers() {
        return (ArrayList<UserEz>) userRepository.findAll();
    }

    public void deleteUser(UserEz user) {
        userRepository.delete(user);
    }

}