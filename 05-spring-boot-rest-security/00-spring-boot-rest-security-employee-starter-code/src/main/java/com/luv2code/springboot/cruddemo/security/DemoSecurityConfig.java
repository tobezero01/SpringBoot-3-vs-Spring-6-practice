package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception {
        httpSecurity.authorizeHttpRequests(
                config ->
                        config.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP Basic config authentication
        httpSecurity.httpBasic((Customizer.withDefaults()));

        // disable CSRF
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
