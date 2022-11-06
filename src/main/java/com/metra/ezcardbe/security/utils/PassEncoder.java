package com.metra.ezcardbe.security.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PassEncoder {

    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }

}
