package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails duc = User.builder()
                .username("duc")
                .password("{noop}ducnhu1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails kien = User.builder()
                .username("kien")
                .password("{noop}ducnhu1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails minh = User.builder()
                .username("minh")
                .password("{noop}ducnhu1234")
                .roles("EMPLOYEE", "MANAGER" , "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(duc,kien,minh);
    }
}
