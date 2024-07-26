package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
                .password("ducnhu1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails kien = User.builder()
                .username("kien")
                .password("ducnhu1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails dung = User.builder()
                .username("dung")
                .password("ducnhu1234")
                .roles("EMPLOYEE", "MANAGER" , "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(duc, kien,dung);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                config -> config.anyRequest().authenticated()
        ).formLogin(
                form -> form.loginPage("/showMyLoginPage")
                        .loginProcessingUrl("authenticateTheUser")
                        .permitAll()
        );

        return httpSecurity.build();
    }

}
